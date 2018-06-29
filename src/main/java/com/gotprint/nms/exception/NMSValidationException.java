package com.gotprint.nms.exception;

public class NMSValidationException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NMSValidationException(String message) {
        super(message);
    }

    /**
     *
     * @param ex
     */
    public NMSValidationException(Exception ex) {
        super(ex);
    }


    /**
     *
     * @param ex
     * @param message
     */
    public NMSValidationException(Exception ex,String message) {
        super(message,ex);
    }

}
