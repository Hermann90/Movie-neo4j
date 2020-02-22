package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import movies.spring.data.neo4j.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Hermann90
 */
@RestController
@RequestMapping("/")
public class RoleController {
    
    // private final static Logger LOG = LoggerFactory.getLogger(RoleService.class);

    private final RoleService roleService;
    

    public RoleController(RoleService movieService) {
        this.roleService = movieService;
    }
    
    @PostMapping("/graph/save/role")
    public Role saveMovie(
                    @RequestParam String personName,
                    @RequestParam String movieTitle,
                    @RequestParam String roleName) {
        System.out.println("\n\nRoleController+++++++++++++++>>>>> " + "roleName : "+roleName+ 
                " namePerson : "+personName+"nameMovie :" +movieTitle+"\n\n");

        return roleService.saveRole(personName,movieTitle,  roleName);
    }
}
