package pl.example.spring.punkty;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoStudentException extends RuntimeException {
    public NoStudentException(long id) {
        super("Student o id :"+id+" does not exists");}

}
