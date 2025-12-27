package mtech.car.rental.infra.business;

public class RequiredFieldException extends BusinessException{
    public RequiredFieldException() {
        super("1", "Required field", "Insert a resource earlier");
    }
}
