package com.jumio.persistence;

public class PersistenceException extends Exception {
    public PersistenceException(Exception exception) {
        super(exception);
    }

    public PersistenceException(String str) {
        super(str);
    }
}
