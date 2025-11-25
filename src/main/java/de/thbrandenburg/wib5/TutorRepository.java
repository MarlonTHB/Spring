package de.thbrandenburg.wib5;
import org.springframework.data.repository.Repository;
import java.util.List;

public interface TutorRepository extends Repository<Tutor, Integer> {
   Tutor findById(Long id);

   void save(Tutor tutor);

   List<Tutor> findAll();

   void delete(Tutor tutor);
}
