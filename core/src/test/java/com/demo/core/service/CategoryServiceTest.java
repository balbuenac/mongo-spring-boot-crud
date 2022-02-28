package com.demo.core.service;

import com.demo.common.constant.ExceptionMessages;
import com.demo.common.exceptions.CategoryException;
import com.demo.common.response.CategoryResponse;
import com.demo.core.service.util.TestGenerator;
import com.demo.domain.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.demo.common.constant.Constant.SUCCESS;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository repo;

    @InjectMocks
    private CategoryService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCategory() {
        Mockito.when(repo.save(Mockito.any())).thenReturn(TestGenerator.buildCategory());
        CategoryResponse response = service.create(TestGenerator.buildCategoryRequest());
        Assertions.assertEquals(response.getMessage(), SUCCESS);
    }

    @Test
    public void testDeleteCategory() {
        Mockito.when(repo.findByName(Mockito.any())).thenReturn(TestGenerator.buildCategories());
        Mockito.doNothing().when(repo).delete(Mockito.any());
        CategoryResponse response = service.delete(TestGenerator.buildCategoryRequest().getName());
        Assertions.assertEquals(response.getMessage(), SUCCESS);
    }

    @Test
    public void testDeleteCategoryNotFound() {
        Mockito.when(repo.findByName(Mockito.any())).thenThrow(new CategoryException(ExceptionMessages.NO_CATEGORIES_EXIST));
        Assertions.assertThrows(
                CategoryException.class,
                () -> {
                    service.delete(TestGenerator.buildCategoryRequest().getName());
                });
    }

}
