package controlador.sd.exception;

public class FullException extends Exception {

    /**
     * Creates a new instance of <code>VacioException</code> without detail
     * message.
     */
    public FullException() {
    }

    /**
     * Constructs an instance of <code>VacioException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public FullException(String msg) {
        super(msg);
    }
}