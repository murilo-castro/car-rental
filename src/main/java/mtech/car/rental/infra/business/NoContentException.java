package mtech.car.rental.infra.business;

public class NoContentException extends BusinessException{
    public NoContentException() {
        super("3", "Query without records", "Insert a resource earlier");
    }
}
