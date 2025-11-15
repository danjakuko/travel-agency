package com.protik.travel_agency.entities;

import com.protik.travel_agency.static_data.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class AppUser extends GenericEntity {
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private boolean active;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
