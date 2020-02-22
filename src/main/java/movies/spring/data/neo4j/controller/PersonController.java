package movies.spring.data.neo4j.controller;


import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hermann90
 */
@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService movieService;

    public PersonController(PersonService movieService) {
        this.movieService = movieService;
    }


    
      @PostMapping("/graph/save/person")
    public Person saveMovie(@RequestBody Person movie) {
        return movieService.savePerson(movie);
    }
}
