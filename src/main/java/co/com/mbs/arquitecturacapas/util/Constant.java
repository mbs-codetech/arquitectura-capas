package co.com.mbs.arquitecturacapas.util;

public class Constant {
    public enum ResponseMessagesEnum{
        SUCCESSFUL_CONSULT("Consulta realizada exitosamente"),
        BASE_CREATED_SUCCESSFULLY("%s se ha creado exitosamente"),
        BASE_UPDATED_SUCCESSFULLY("%s se ha actualizado exitosamente");

        private String message;
        ResponseMessagesEnum(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }
}
