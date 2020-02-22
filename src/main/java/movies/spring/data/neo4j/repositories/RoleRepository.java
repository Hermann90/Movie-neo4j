package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author Hermann90
 */
public interface RoleRepository extends Neo4jRepository<Role , Long> {

}