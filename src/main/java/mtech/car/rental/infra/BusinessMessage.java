package mtech.car.rental.infra;

import org.springframework.http.HttpStatus;

public enum BusinessMessage {
    E500("500", "Erro não mapeado", "Contacte o Suporte Técnico") {
        @Override
        public int getHttpStatus() {
            return 500;
        }
    },
    E501("501", "Erro ao tentar acessar o recurso", "Contacte o Suporte Técnico") {
        @Override
        public int getHttpStatus() {
            return 500;
        }
    };
    private final String code;
    private final String message;
    private final String suggestion;

    private int httpStatus;

    private BusinessMessage(String code, String message, String suggestion) {
        this.code = code;
        this.message = message;
        this.suggestion = suggestion;
    }

    public int getHttpStatus() {
        return HttpStatus.CONFLICT.value();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
