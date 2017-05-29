package net.systemic.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.systemic.rest.domain.User;
import net.systemic.rest.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kelvinashu
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/userservice")
public class UserService {

    /**
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUserts() {
        return getAllUsers();
    }

    /**
     *
     * @param user
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> update(@RequestBody User user) {
        if (user.getFirstName() != null && user.getLastName() != null
                && user.getDateOfBirth() != null && user.getAge() != null
                && user.getSalary() != null) {
            Persistence persistObj = new Persistence();
            persistObj.addUser(user);
            return new ResponseEntity("User successfully added.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Provide mandatory fields", HttpStatus.BAD_REQUEST);
        }

    }

    /**
     *
     * @return
     */
    public List<User> getAllUsers() {
        Persistence persistObj = new Persistence();
        List<User> userList = new ArrayList<>();
        try {
            userList = persistObj.getAllUsers();
        } catch (Exception e) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
        }

        return userList;
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserService.class, args);
    }

}
