package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CLIENT')")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getOneUser(id),
                HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteOneUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id),
                HttpStatus.OK);
    }

    @PutMapping("person/edit")
    public ResponseEntity<?> updateUserInfo(@RequestBody User user) {
        return new ResponseEntity<>(userService.updatePersonInfo(user),
                HttpStatus.OK);
    }

    @GetMapping("person/{id}")
    public ResponseEntity<?> getPersonInfo(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getPersonDetails(id),
                HttpStatus.OK);
    }

}
