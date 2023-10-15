package project.tema21.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int id;

    private String text;

    private String reviewer;

    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    @JoinColumn(name = "movie_rated_id")
    private Movie belongingMovie;

    public Review(String text, String reviewer, Movie belongingMovie) {
        this.text = text;
        this.reviewer = reviewer;
        this.belongingMovie = belongingMovie;
    }

    public Review(int id, String text, String reviewer, Movie belongingMovie) {
        this.id = id;
        this.text = text;
        this.reviewer = reviewer;
        this.belongingMovie = belongingMovie;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Movie getBelongingMovie() {
        return belongingMovie;
    }

    public void setBelongingMovie(Movie belongingMovie) {
        this.belongingMovie = belongingMovie;
    }


}
