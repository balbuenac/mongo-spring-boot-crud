package com.demo.core.service.util;

import com.demo.common.request.CategoryRequest;
import com.demo.model.Category;

import java.util.List;

public class TestGenerator {

    public static CategoryRequest buildCategoryRequest() {
        return new CategoryRequest("Carlos", "This is a human");
    }

    public static Category buildCategory() {
        return new Category("Carlos", "This is a human");
    }

    public static List<Category> buildCategories() {
        return List.of(new Category("Carlos", "This is a human"));
    }

}
