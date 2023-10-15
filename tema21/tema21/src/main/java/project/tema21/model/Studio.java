package project.tema21.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studio")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private int id;

    private String studioName;

    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "studio")
    @JsonBackReference
    private List<Movie> moviesProduced;

    public Studio(String studioName, String address, List<Movie> moviesProduced) {
        this.studioName = studioName;
        this.address = address;
        this.moviesProduced = moviesProduced;
    }

    public Studio(int id, String studioName, String address, List<Movie> moviesProduced) {
        this.id = id;
        this.studioName = studioName;
        this.address = address;
        this.moviesProduced = moviesProduced;
    }

    public Studio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Movie> getMoviesProduced() {
        return moviesProduced;
    }

    public void setMoviesProduced(List<Movie> moviesProduced) {
        this.moviesProduced = moviesProduced;
    }


    public void addMovie(Movie movie) {
        if (moviesProduced == null) {
            this.moviesProduced = new ArrayList<>();
        }
        this.moviesProduced.add(movie);
    }


}
