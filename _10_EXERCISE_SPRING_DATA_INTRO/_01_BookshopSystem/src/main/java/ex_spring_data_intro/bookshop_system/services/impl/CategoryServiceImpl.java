package ex_spring_data_intro.bookshop_system.services.impl;

import ex_spring_data_intro.bookshop_system.entities.Category;
import ex_spring_data_intro.bookshop_system.repositories.CategoryRepository;
import ex_spring_data_intro.bookshop_system.services.interfaces.CategoryService;
import ex_spring_data_intro.bookshop_system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORY_FILE_PATH =
            "C:\\JAVA_PROJECTS\\HibernateORM\\_10_EXERCISE_SPRING_DATA_INTRO\\_01_BookshopSystem\\src\\main\\resources\\files\\categories.txt";
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() != 0) {
            return;
        }

        String[] lines = this.fileUtil.fileContent(CATEGORY_FILE_PATH);
        for (String line : lines) {
            Category category = new Category();
            category.setName(line);
            this.categoryRepository.saveAndFlush(category);
        }
    }
}
