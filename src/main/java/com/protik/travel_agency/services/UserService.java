package com.protik.travel_agency.services;

import com.protik.travel_agency.entities.AppUser;
import com.protik.travel_agency.models.UserRequest;
import com.protik.travel_agency.repositories.UserRepository;
import com.protik.travel_agency.static_data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUser create(UserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public AppUser findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        AppUser appUser = this.findById(id);
        appUser.setActive(false);
        userRepository.save(appUser);
    }

    public AppUser update(UserRequest user) {
        AppUser appuser = findById(user.getId());
        if (appuser.getUsername().equals(user.getUsername())) {
            appuser.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(appuser);
        } else {
            if (userRepository.existsByUsername(user.getUsername())) {
                throw new RuntimeException("User already exists");
            } else {
                appuser.setUsername(user.getUsername());
                appuser.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(appuser);
            }
        }

    }

    public AppUser getLoggedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            throw new IllegalStateException("No user is currently logged in.");
        }

        return this.findByUsername(authentication.getName());
    }
}


