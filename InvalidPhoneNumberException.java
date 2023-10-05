package Exception03;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String mesage) {
        super(mesage);
    }
}
