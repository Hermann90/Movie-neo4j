package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.*;

/**
 * @author Hermann90
 */
@RelationshipEntity(type = "ACTED_IN")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Movie movie;

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    
    public Role(Movie movie, Person actor) {
        this.movie = movie;
        this.person = actor;
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Person getPerson() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(name);
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", roles=" + roles + ", person=" + person + ", movie=" + movie + '}';
    }
    
    
}
