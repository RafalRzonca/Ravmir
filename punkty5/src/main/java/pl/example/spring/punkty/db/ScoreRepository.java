package pl.example.spring.punkty.db;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreRow, Long> {
}
