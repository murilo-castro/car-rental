package mtech.car.rental.infra.http;

import mtech.car.rental.infra.business.BusinessException;
import mtech.car.rental.infra.business.NoContentException;
import mtech.car.rental.infra.business.ResourceNotFoundException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class ResponseFactory {
    public static Response okOrNotFound(Object value) {
        return okOrNotFound(value, "Resource found successfully");
    }

    public static Response okOrNotFound(Optional optional) {
        return okOrNotFound(optional, "Resource found successfully");
    }

    public static Response okOrNotFound(Optional optional, String message) {
        if (optional.isPresent())
            return ok(optional.get(), message);
        else
            throw new ResourceNotFoundException();
    }

    public static Response okOrNotFound(Object value, String message) {
        ResourceNotFoundException exception = new ResourceNotFoundException();
        Optional.ofNullable(value).orElseThrow(() -> exception);
        return ok(value, message);
    }

    public static Response okOrNoContent(Object value) {
        NoContentException exception = new NoContentException();
        if (value == null)
            throw exception;

        String msg = "Query completed successfully";
        if (value instanceof Collection) {
            if (((Collection) value).isEmpty())
                throw exception;
            return ok(value, msg);
        } else
            return null;

    }

    public static Response ok(Object body) {
        return ok(body, "Query completed successfully");
    }

    public static Response ok(Object body, String message) {
        return response(HttpStatus.OK.value(), body, message);
    }

    public static Response create(Object body, String message) {
        return response(HttpStatus.CREATED.value(), body, message);
    }

    private static Response response(Serializable code, Object body, String message) {
        return define(code, body, message, "", true);
    }

    public static Response error() {
        return error("Error", "Contact Technical Support");
    }

    public static Response exception(BusinessException be) {
        return error(be.getId(), be.getMessage(), be.getSuggestion());
    }

    public static Response error(String message, String suggestion) {
        return error(500, message, suggestion);
    }

    public static Response error(Serializable code, String message, String suggestion) {
        return define(code, null, message, suggestion, false);
    }

    private static Response define(Serializable code, Object body, String message, String suggestion, boolean success) {
        Response response = new Response();
        ResponseStatus status = new ResponseStatus();
        status.code = code;
        status.message = message;
        status.suggestion = suggestion;
        status.success = success;
        response.setStatus(status);
        response.setBody(body);
        return response;
    }
}

