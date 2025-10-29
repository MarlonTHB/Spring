package de.thbrandenburg.wib5;


import org.springframework.data.repository.Repository;

public interface TutorRepository extends Repository<Tutor, Integer> {
   Tutor findBy(Integer id);
   Tutor findByHourlyRateBetween(float min, float max);
}
