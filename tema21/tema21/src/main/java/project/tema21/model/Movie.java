package project.tema21.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    private String movieName;

    private int releaseYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rating_id")
    private MovieRating movieRating;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "belongingMovie")
    private List<Review> reviews;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "studio_id")
    private Studio studio;


    @ManyToMany
    @JoinTable (
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;


    public Movie(int movieId, String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews, Studio studio, List<Actor> actors) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studio = studio;
        this.actors = actors;
    }

    public Movie(String movieName, int releaseYear, List<Actor> actors) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.actors = actors;
    }

    public Movie(String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews, Studio studio, List<Actor> actors) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studio = studio;
        this.actors = actors;
    }

    public Movie(int movieId, String movieName, int releaseYear, MovieRating movieRating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
    }

    public Movie(String movieName, int releaseYear, MovieRating movieRating) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
    }

    public Movie(String movieName, int releaseYear) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
    }

    public Movie(int movieId, String movieName, int releaseYear) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
    }

    public Movie(String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
    }

    public Movie(String movieName, int releaseYear, MovieRating movieRating, List<Review> reviews, Studio studio) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studio = studio;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        if (reviews == null) {
            this.reviews = new ArrayList<>();
        }
        else {
            this.reviews.add(review);
        }
    }

    public void removeReview(Review review) {
        if (review == null) {
            this.reviews = new ArrayList<>();
        }
        else {
            this.reviews.remove(review);
        }
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
