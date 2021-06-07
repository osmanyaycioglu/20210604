package com.training.spring.clients;

import com.training.spring.rest.error.ErrorObj;

public class MyRestException extends Exception {

    private static final long serialVersionUID = -3124054079074884895L;

    private final ErrorObj    errorObj;

    public MyRestException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }

    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


}
