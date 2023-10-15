package project.tema21.repository;

import project.tema21.model.Actor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActorReader {

    public static List<Actor> giveActors() {

        List<Actor> actors = new ArrayList<>();
        Actor firstActor = new Actor("Brad Pitt", 1968);
        Actor secondActor = new Actor("Leonardo Dicaprio", 1988);
        Actor thirdActor = new Actor("Florin Piersic", 1950);

        actors.add(firstActor);
        actors.add(secondActor);
        actors.add(thirdActor);

        return actors;

    }
}
