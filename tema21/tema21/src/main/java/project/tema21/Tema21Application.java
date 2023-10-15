package project.tema21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.tema21.model.*;
import project.tema21.repository.*;

import java.util.ArrayList;
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


			Actor firstActor = new Actor("Brad Pitt", 1968, null);
			Actor secondActor = new Actor("Leonardo Dicaprio", 1988, null);
			Actor thirdActor = new Actor("Florin Piersic", 1950, null);


			Studio studio = new Studio("Columbia", "America-5883", null);

			Review reviewOne = new Review("A fost bun", "George", null);
			Review reviewTwo = new Review("Cam Naspa", "Laurentiu", null);


			MovieRating rating = new MovieRating(10, "Columbia", null);

			Movie init = new Movie("incercare", 0, null, new ArrayList<>(), null , new ArrayList<>());

			Movie firstMovie = new Movie("Interstellar", 2010, rating,
					List.of(reviewOne, reviewTwo), studio, List.of(firstActor, secondActor, thirdActor));
			firstActor.addMovie(firstMovie);
			secondActor.addMovie(firstMovie);
			thirdActor.addMovie(firstMovie);
			rating.setBelongingMovie(firstMovie);
			reviewOne.setBelongingMovie(firstMovie);
			reviewTwo.setBelongingMovie(firstMovie);
			studio.addMovie(firstMovie);

			movieRepository.save(firstMovie);




		};
	}

}
