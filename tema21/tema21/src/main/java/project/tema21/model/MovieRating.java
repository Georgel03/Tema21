package project.tema21.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_rating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int id;

    private int rating;

    private String agency;

    @OneToOne
    @JoinColumn(name = "rating_of_movie_id")
    @JsonIgnore
    private Movie belongingMovie;


    public MovieRating() {
    }

    public MovieRating(int rating, String agency, Movie belongingMovie) {
        this.rating = rating;
        this.agency = agency;
        this.belongingMovie = belongingMovie;
    }

    public MovieRating(int id, int rating, String agency, Movie belongingMovie) {
        this.id = id;
        this.rating = rating;
        this.agency = agency;
        this.belongingMovie = belongingMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Movie getBelongingMovie() {
        return belongingMovie;
    }

    public void setBelongingMovie(Movie belongingMovie) {
        this.belongingMovie = belongingMovie;
    }
}
