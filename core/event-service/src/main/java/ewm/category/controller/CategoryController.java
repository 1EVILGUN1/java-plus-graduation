package ewm.category.controller;

import ewm.category.service.CategoryService;
import ewm.dto.category.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getCategories(
            @RequestParam(defaultValue = "0") Integer from,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return categoryService.getAll(from, size);
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }
}
