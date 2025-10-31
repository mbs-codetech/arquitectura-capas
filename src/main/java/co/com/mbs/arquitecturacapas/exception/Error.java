package co.com.mbs.arquitecturacapas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
    private String mensaje;
    private LocalDateTime fecha;
}
