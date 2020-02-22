package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private final static Logger LOG = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private  PersonRepository movieRepository;

    
     @Transactional(readOnly = true)
    public Person savePerson(Person person) {
         Person result = movieRepository.save(person);
        return result;
    }
}
