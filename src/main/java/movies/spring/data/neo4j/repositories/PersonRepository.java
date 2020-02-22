package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Hermann90
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByName(String name);
    
    @Query("MATCH (p:Person) Where p.name ={0} RETURN p")
    Person findByIdName(String name);

}