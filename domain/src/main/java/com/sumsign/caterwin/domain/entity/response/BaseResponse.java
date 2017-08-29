package com.sumsign.caterwin.domain.entity.response;

/**
 * Created by Long Nguyen on 17/7/2017.
 */

public class BaseResponse {
    boolean success;
    String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
