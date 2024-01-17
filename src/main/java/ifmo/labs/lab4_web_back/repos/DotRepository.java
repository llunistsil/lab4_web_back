package ifmo.labs.lab4_web_back.repos;

import ifmo.labs.lab4_web_back.models.Dot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DotRepository extends JpaRepository<Dot, Long> {
    List<Dot> getDotsByOwner(String owner);

    void deleteByOwner(String owner);
}