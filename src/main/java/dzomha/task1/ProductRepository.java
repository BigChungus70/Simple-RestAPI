package dzomha.task1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
            extends JpaRepository<Product, Integer> {

    @Query("SELECT u FROM Product u WHERE u.name = ?1")
    public Product findByName(String name);

}

