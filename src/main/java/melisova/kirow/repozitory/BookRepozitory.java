package melisova.kirow.repozitory;

import melisova.kirow.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepozitory  extends CrudRepository<Book,Long> {
    Optional<Book> findById(Long id);

}
