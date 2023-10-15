package project.tema21.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "Actor")
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;

    private String actorName;

    private int birthYear;

    @JsonManagedReference
    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();

    public Actor(int id, String actorName, int birthYear) {
        this.id = id;
        this.actorName = actorName;
        this.birthYear = birthYear;
    }

    public Actor(String actorName, int birthYear) {
        this.actorName = actorName;
        this.birthYear = birthYear;
    }

    public Actor() {
    }

    public Actor(int id, String actorName, int birthYear, List<Movie> movies) {
        this.id = id;
        this.actorName = actorName;
        this.birthYear = birthYear;
        this.movies = movies;
    }

    public Actor(String actorName, int birthYear, List<Movie> movies) {
        this.actorName = actorName;
        this.birthYear = birthYear;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public List<Movie> getMoviesMade() {
        return movies;
    }

    public void setMoviesMade(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (this.movies == null) {
            this.movies = new ArrayList<>();
        }
        this.movies.add(movie);
    }


}
