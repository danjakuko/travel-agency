package com.protik.travel_agency.repositories;

import com.protik.travel_agency.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
Optional<AppUser> findByUsername (String username);
Boolean existsByUsername (String username);

}
