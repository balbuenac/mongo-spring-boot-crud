package com.demo.core.service;

import com.demo.common.constant.ExceptionMessages;
import com.demo.common.exceptions.CategoryException;
import com.demo.common.request.CategoryRequest;
import com.demo.common.response.CategoryResponse;
import com.demo.core.service.util.Generator;
import com.demo.domain.repository.CategoryRepository;
import com.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public CategoryResponse create(CategoryRequest request) {
        Category newCategory = Generator.build(request.getName(), request.getDescription());
        repo.save(newCategory);
        return Generator.buildResponse();
    }

    public CategoryResponse update(String name, String newDescription) {
        List<Category> categories = repo.findByName(name);
        if (categories.size() > 0) {
            categories.stream().forEach(it -> {
                it.setDescription(newDescription);
                repo.save(it);
            });
            return Generator.buildResponse();
        }
        throw new CategoryException(ExceptionMessages.NO_CATEGORIES_EXIST);
    }

    public CategoryResponse delete(String name) {
        List<Category> categories = repo.findByName(name);
        if (categories.size() > 0) {
            repo.deleteAll(categories);
            return Generator.buildResponse();
        }
        throw new CategoryException(ExceptionMessages.NO_CATEGORIES_EXIST);
    }

    public List<Category> list() {
        return repo.findAll();
    }

    public List<Category> listByName(String name) {
        return repo.findByName(name);
    }

}
