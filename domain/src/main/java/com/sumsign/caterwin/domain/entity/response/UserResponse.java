package com.sumsign.caterwin.domain.entity.response;

import com.sumsign.caterwin.domain.entity.UserEntity;

/**
 * Created by Long Nguyen on 17/7/2017.
 */

public class UserResponse extends BaseResponse {
    UserEntity data;

    public UserEntity getData() {
        return data;
    }
}
