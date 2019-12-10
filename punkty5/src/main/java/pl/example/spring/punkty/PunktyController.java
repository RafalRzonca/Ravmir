package pl.example.spring.punkty;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {

    //private CopyOnWriteArrayList<String> students = new CopyOnWriteArrayList<>(Arrays.asList("Student 1" , "Student 2", "Student 3"));

    //private StudentService service = new StudentService(repository);

    public PunktyController(StudentService service) {
        this.service = service;
    }

    private final StudentService service;


    @RequestMapping(value = "/students",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Student> getUsers() {
        return this.service.getStudents().asJava();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Student addStudent(@RequestBody NewStudent student) {
        return this.service.addStudent(student);
    }


    @RequestMapping(value = "/students/{id}/number/{number}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Student setNumber(@PathVariable("id") long id, @PathVariable("number") String number) {
        return this.service.changeNumber(id, number).orElseThrow(
                () -> new IllegalArgumentException("Student o id: " + id + " does not exist") );

    }

    @RequestMapping(value = "/students/{id}/scores", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addScore(@RequestBody Score score, @PathVariable("id") long id){
        return this.service.addScore(id, score)
                .orElseThrow(
                        ()->new NoStudentException(id));


    }

}
