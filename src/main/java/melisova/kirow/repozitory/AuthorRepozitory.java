package melisova.kirow.repozitory;

import melisova.kirow.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepozitory extends CrudRepository<Author, Long> {
    Optional<Author> findById(Long id);
}
