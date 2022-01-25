package system.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.model.User;
import system.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> select() {
        final List<User> users = userService.selectAll();

        if ( users != null &&  !users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> select(@PathVariable(name = "id") int id) {
        final User user = userService.selectById(id);

        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> update(@PathVariable(name = "id") int id,
                                    @RequestBody User user) {
        final boolean updated = userService.update(user, id);

        if (updated)
           return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.deleteById(id);

        if (deleted)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
