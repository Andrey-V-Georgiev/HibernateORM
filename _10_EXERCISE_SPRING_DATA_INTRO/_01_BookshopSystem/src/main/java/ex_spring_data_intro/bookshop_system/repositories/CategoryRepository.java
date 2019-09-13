package ex_spring_data_intro.bookshop_system.repositories;

import ex_spring_data_intro.bookshop_system.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
