package project.tema21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.tema21.model.*;
import project.tema21.repository.*;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Tema21Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema21Application.class, args);
	}

	@Bean
	CommandLineRunner atStartup (MovieRepository movieRepository,
								 MovieRatingRepository movieRatingRepository,
								 ReviewRepository reviewRepository,
								 StudioRepository studioRepository,
								 ActorRepository actorRepository) {
		return args -> {

			List<Movie> movieList = MovieReader.generateMovies();
			Movie firstMovie = movieList.get(0);
			

			//ONE-TO-ONE
			MovieRating rating = new MovieRating(10, "Columbia");
			rating.setBelongingMovie(firstMovie);
			firstMovie.setMovieRating(rating);

			//ONE-TO-MANY
			Review reviewOne = new Review("A fost bun", "George");
			Review reviewTwo = new Review("Cam Naspa", "Laurentiu");
			firstMovie.addReview(new Review("incercare", "incercare"));
			firstMovie.addReview(reviewOne);
			reviewOne.setBelongingMovie(firstMovie);
			firstMovie.addReview(reviewTwo);
			reviewTwo.setBelongingMovie(firstMovie);



			//MANY-TO-ONE
			Movie secondMovie = movieList.get(1);
			Movie thirdMovie = movieList.get(2);
			Movie fourthMovie = movieList.get(3);
			Studio studio = new Studio("Columbia", "America-5883");
			studio.addMovie(new Movie());
			studio.addMovie(secondMovie);
			secondMovie.setStudio(studio);
			studio.addMovie(thirdMovie);
			thirdMovie.setStudio(studio);
			fourthMovie.setStudio(studio);
			studio.addMovie(fourthMovie);



			//MANY-TO-MANY
			Actor firstActor = new Actor("Brad Pitt", 1968);
			actorRepository.save(firstActor);
			Actor secondActor = new Actor("Leonardo Dicaprio", 1988);
			actorRepository.save(secondActor);
			Actor thirdActor = new Actor("Florin Piersic", 1950);
			actorRepository.save(thirdActor);

			Movie m1 = new Movie("Casablanca", 1977, List.of(firstActor, secondActor));
			Movie m2 = new Movie("Oppenheimer", 2023, List.of(secondActor, thirdActor));
			Movie m3 = new Movie("Margelatu", 2023, List.of(thirdActor));

			firstActor.addMovie(m1);
			secondActor.addMovie(m1);
			secondActor.addMovie(m2);
			thirdActor.addMovie(m2);
			thirdActor.addMovie(m3);

			movieList.add(m1);
			movieList.add(m2);
			movieList.add(m3);


			movieRepository.saveAll(movieList);

		};
	}

}
