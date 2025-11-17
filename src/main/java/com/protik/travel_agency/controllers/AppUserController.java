package com.protik.travel_agency.controllers;

import com.protik.travel_agency.entities.AppUser;
import com.protik.travel_agency.models.UserRequest;
import com.protik.travel_agency.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public AppUser createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/by_id")
    public AppUser findById(@RequestParam Long id) {
        return userService.findById(id);
    }

    @GetMapping("/by_username")
    public AppUser findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/update")
    public AppUser updateUser(@RequestBody UserRequest userRequest) {
        return userService.update(userRequest);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id) {
        userService.delete(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/get_logged_user")
    public ResponseEntity<AppUser> getLoggedUser() {
        AppUser user = userService.getLoggedUser();
        return ResponseEntity.ok(user);
    }
}
