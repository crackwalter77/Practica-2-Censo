package controlador.sd.exception;

public class PositionException extends Exception {

    /**
     * Creates a new instance of <code>VacioException</code> without detail
     * message.
     */
    public PositionException() {
    }

    /**
     * Constructs an instance of <code>VacioException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public PositionException(String msg) {
        super(msg);
    }
}