package pl.example.spring.punkty.db;

import javax.persistence.*;

@Entity
public class ScoreRow {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;
    private String comment;


    @ManyToOne
    private StudentRow student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StudentRow getStudent() {
        return student;
    }

    public void setStudent(StudentRow student) {
        this.student = student;
    }

    public ScoreRow(int score, String comment, StudentRow student) {
        this.score = score;
        this.comment = comment;
        this.student = student;}
    protected ScoreRow() {}
}
