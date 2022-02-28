package com.demo.common.util;

import com.demo.common.response.CategoryResponse;

import static com.demo.common.constant.Constant.SUCCESS;

public class Generator {

    public static CategoryResponse buildResponse() {
        return new CategoryResponse(SUCCESS, SUCCESS);
    }

}
