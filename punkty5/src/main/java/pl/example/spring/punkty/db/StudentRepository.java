package pl.example.spring.punkty.db;


import org.springframework.data.repository.CrudRepository;
import pl.example.spring.punkty.db.StudentRow;

public interface StudentRepository extends CrudRepository<StudentRow,Long> {
}
