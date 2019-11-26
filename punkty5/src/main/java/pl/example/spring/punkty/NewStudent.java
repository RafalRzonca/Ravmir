package pl.example.spring.punkty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {

    @JsonProperty("name") public final String name;
    @JsonProperty("number")public final String number;
    @JsonProperty("grupa")public final String group1;

    @JsonCreator
    public NewStudent(String name, String number, String group1) {
        this.name = name;
        this.number = number;
        this.group1 = group1;

    }
}
