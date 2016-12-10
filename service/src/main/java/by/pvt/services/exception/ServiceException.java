package by.pvt.services.exception;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ServiceException extends Exception{
    public ServiceException(String message, Exception exception) {
        super(message, exception);
    }

    public ServiceException(Exception exception) {
        super(exception);
    }
}
