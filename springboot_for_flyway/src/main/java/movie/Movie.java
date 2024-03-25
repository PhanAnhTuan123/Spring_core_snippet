package movie;

import actor.Actor;

import java.time.LocalDate;
import java.util.List;

public record Movie (
        String name,
        List<Actor>actors,
        LocalDate releaseDate

){
}
