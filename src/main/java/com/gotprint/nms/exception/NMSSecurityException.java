package com.gotprint.nms.exception;

public class NMSSecurityException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NMSSecurityException(String message) {
        super(message);
    }

    /**
     *
     * @param ex
     */
    public NMSSecurityException(Exception ex) {
        super(ex);
    }


    /**
     *
     * @param ex
     * @param message
     */
    public NMSSecurityException(Exception ex,String message) {
        super(message,ex);
    }

}
