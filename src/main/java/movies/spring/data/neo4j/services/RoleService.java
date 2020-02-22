/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies.spring.data.neo4j.services;

import java.util.ArrayList;
import java.util.List;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.domain.Role;
import movies.spring.data.neo4j.repositories.MovieRepository;
import movies.spring.data.neo4j.repositories.PersonRepository;
import movies.spring.data.neo4j.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hermann90
 */
@Service
public class RoleService {
    //private final static Logger LOG = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Role saveRole(String personName, String movieTitle, String roleName) {
        Role role = new Role();
        List<String> rolesList = new ArrayList<>();
        System.out.println("\n\n saveRole 1+++++++++++++++>>>>> "
                + "roleName : " + roleName + " namePerson : " + personName + "nameMovie :" + movieTitle + "\n\n");

        Person p = new Person();
        Movie m = new Movie();
        p = personRepository.findByIdName(personName);
        m = movieRepository.findByIdName(movieTitle);

        if (p == null) {
            System.out.println("\n\nsaveRole 2+++++++++++++++>>>>> Personn is null \n\n");
        }

        if (m == null) {
            System.out.println("\n\n saveRole 3+++++++++++++++>>>>> Movie is null \n\n");
        }
        
        System.out.println("\n\n saveRole 4+++++++++++++++++>>>>>>>Personn is : " + p.toString());
        System.out.println("\n\n saveRole 5+++++++++++++++++>>>>>>>Movie is : " + m.toString());

        role.setMovie(m);
        role.setPerson(p);
        rolesList.add(roleName);
        role.setRoles(rolesList);
        System.out.println("\n\n saveRole 6+++++++++++++++++>>>>>>>role is : " + role.toString());

        Role result = roleRepository.save(role);
        return result;
    }
}
