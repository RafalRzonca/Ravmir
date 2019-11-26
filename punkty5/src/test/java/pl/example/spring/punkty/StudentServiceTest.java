package pl.example.spring.punkty;

import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.example.spring.punkty.db.StudentRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void getEmptyList() {

        final StudentService service = new StudentService(repository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);

    }

    @Test
    public void addStudentIsReturned() {

        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("StudentTestowy","1-2-3","IP31"));
        final List<Student> all = service.getStudents();

        assertEquals("StudentTestowy",all.get(0).name);
    }

    @Test
    public void addStudentHasNewId() {
        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("StudentTestowy","1-2-3","IP31"));
        final Student created2 = service.addStudent(new NewStudent("StudentTestowy2","3-5-8","IP32"));

        assertEquals(2,service.getStudents().size());
        assertNotEquals(created.id,created2.id);
    }
    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }


}