package pl.example.spring.punkty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {

    public final String name;
    public final String number;
    public final String group1;

    @JsonCreator
    public NewStudent(@JsonProperty("name") String name,
                      @JsonProperty("number") String number,
                      @JsonProperty("group1") String group1) {
        this.name = name;
        this.number = number;
        this.group1 = group1;

    }
}
