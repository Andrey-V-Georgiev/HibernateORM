package ex_spring_data_intro.bookshop_system.repositories;

import ex_spring_data_intro.bookshop_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
