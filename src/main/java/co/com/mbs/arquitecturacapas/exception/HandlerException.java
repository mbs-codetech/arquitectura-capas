package co.com.mbs.arquitecturacapas.exception;

import co.com.mbs.arquitecturacapas.validation.ExceptionBase;
import co.com.mbs.arquitecturacapas.validation.InvalidObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HandlerException {
    private static final String MENSAJE_POR_DEFECTO = "Ocurrió un problema al procesar la solicitud";
    public static final Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);
    protected static final ConcurrentMap<String, HttpStatus> STATES = new ConcurrentHashMap<>();

    static {
        STATES.put(InvalidObjectException.class.getSimpleName(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExceptionBase.class)
    public ResponseEntity<Error> solucionarExcepcion(ExceptionBase e){
        HttpStatus status = STATES.get(e.getClass().getSimpleName());
        Error err = new Error(e.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> solucionarExcepcion(Exception e){
        Error err = new Error(MENSAJE_POR_DEFECTO, LocalDateTime.now());
        LOGGER.error(e.getClass().getSimpleName(),e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ConcurrentMap<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ConcurrentMap<String, String> errors = new ConcurrentHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
