package Excepciones;

public class DniEnUsoException extends RuntimeException {

    public DniEnUsoException(String message) {
        super(message);
    }
}
