package mtech.car.rental.infra.business;

public class ResourceNotFoundException extends BusinessException{
    public ResourceNotFoundException() {
        super("2", "Resource not found", "Insert a resource previously");
    }
}
