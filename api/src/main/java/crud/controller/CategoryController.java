package crud.controller;

import com.demo.common.request.CategoryRequest;
import com.demo.common.response.CategoryResponse;
import com.demo.core.service.CategoryService;
import com.demo.model.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.demo.common.route.Route.BASE;
import static com.demo.common.route.Route.BY_NAME;

@RestController
@RequestMapping(value = BASE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public CategoryResponse create(@RequestBody @Valid CategoryRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Category> list() {
        return service.list();
    }

    @GetMapping(BY_NAME)
    public List<Category> listByName(@PathVariable String name) {
        return service.listByName(name);
    }

    @PatchMapping
    public CategoryResponse updateByName(@RequestBody @Valid CategoryRequest request) {
        return service.update(request.getName(), request.getDescription());
    }

    @DeleteMapping
    public CategoryResponse deleteByName(@RequestBody @Valid CategoryRequest request) {
        return service.delete(request.getName());
    }

}
