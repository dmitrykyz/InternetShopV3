package by.pvt.dao.exception;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class DaoException extends Exception {

    private Exception exception;

    public DaoException(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
