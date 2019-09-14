package ex_spring_data_intro.bookshop_system.util;

import ex_spring_data_intro.bookshop_system.entities.Category;
import ex_spring_data_intro.bookshop_system.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CategoryUtil {
    private final CategoryRepository categoryRepository;
    private static Random r;
    private static int categoryId;

    @Autowired
    public CategoryUtil(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> randomSetOfCategories() {
        List<Category> allCategories = this.categoryRepository.findAll();
        Set<Category> bookCategories = new HashSet<>();

        for (int i = 0; i < getRandomNumberInRange(1, 6); i++) {
            categoryId = getRandomNumberInRange(1, allCategories.size());
            Optional<Category> category = this.categoryRepository.findById(categoryId);
            bookCategories.add(category.get());
        }

        return bookCategories;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
