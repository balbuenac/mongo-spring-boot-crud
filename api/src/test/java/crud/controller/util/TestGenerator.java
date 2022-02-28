package crud.controller.util;

import com.demo.common.request.CategoryRequest;
import com.demo.common.response.CategoryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.demo.common.constant.Constant.SUCCESS;

public class TestGenerator {

    public static CategoryRequest buildCategoryRequest() {
        return new CategoryRequest("Carlos", "This is a human");
    }

    public static CategoryResponse buildCategoryResponse() {
        return new CategoryResponse(SUCCESS, SUCCESS);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
