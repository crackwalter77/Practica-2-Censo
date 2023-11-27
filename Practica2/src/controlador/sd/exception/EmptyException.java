package controlador.sd.exception;

public class EmptyException extends Exception {

    /**
     * Creates a new instance of <code>VacioException</code> without detail
     * message.
     */
    public EmptyException() {
    }

    /**
     * Constructs an instance of <code>VacioException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public EmptyException(String msg) {
        super(msg);
    }
}