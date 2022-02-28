package com.demo.core.service.util;

import com.demo.common.response.CategoryResponse;
import com.demo.model.Category;

import static com.demo.common.constant.Constant.SUCCESS;

public class Generator {

    public static Category build(String name, String descripcion) {
        return new Category(name, descripcion);
    }

    public static CategoryResponse buildResponse() {
        return new CategoryResponse(SUCCESS, SUCCESS);
    }

}
