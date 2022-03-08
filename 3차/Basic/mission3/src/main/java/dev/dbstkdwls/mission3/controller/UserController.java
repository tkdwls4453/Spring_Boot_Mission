package dev.dbstkdwls.mission3.controller;

import dev.dbstkdwls.mission3.dto.UserDto;
import dev.dbstkdwls.mission3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class);
    private final UserService userService;

    public UserController(
            @Autowired UserService userService
    ){
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
            @RequestBody UserDto userDto
    ){
        this.userService.createUser(userDto);
    }

    @GetMapping("{id}")
    public UserDto readUser(
            @PathVariable("id") Long id
    ){
        return this.userService.readUser(id);
    }

    @GetMapping()
    public List<UserDto> readUserAll(){
        return this.userService.readUserAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserDto userDto
    ){
        this.userService.updateUser(id,userDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(
            @PathVariable("id") Long id
    ){
        this.userService.deleteUser(id);
    }


}
