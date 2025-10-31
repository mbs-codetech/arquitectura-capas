package co.com.mbs.arquitecturacapas.controller.base;

import co.com.mbs.arquitecturacapas.dto.CustomResponse;
import co.com.mbs.arquitecturacapas.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.util.Objects.isNull;

public abstract class GenericController {
    protected ResponseEntity<CustomResponse> response(Object data){
        if(isNull(data)){
            return ResponseEntity.noContent().build();
        }
        CustomResponse customResponse = CustomResponse.builder().message(Constant.ResponseMessagesEnum.SUCCESSFUL_CONSULT.getMessage())
                .httpCode(HttpStatus.OK.value() + "-" + HttpStatus.OK.name()).data(data).build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    protected ResponseEntity<CustomResponse> created(Object data, String item){
        CustomResponse customResponse = CustomResponse.builder().
                message(String.format(Constant.ResponseMessagesEnum.BASE_CREATED_SUCCESSFULLY.getMessage(),item))
                .httpCode(HttpStatus.CREATED.value() + "-"+HttpStatus.CREATED.name())
                .data(data).build();
        return new ResponseEntity<>(customResponse, HttpStatus.CREATED);
    }

    protected ResponseEntity<CustomResponse> updated(Object data, String item){
        CustomResponse customResponse = CustomResponse.builder().
                message(String.format(Constant.ResponseMessagesEnum.BASE_UPDATED_SUCCESSFULLY.getMessage(),item))
                .httpCode(HttpStatus.OK.value() + "-"+HttpStatus.OK.name())
                .data(data).build();
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

}
