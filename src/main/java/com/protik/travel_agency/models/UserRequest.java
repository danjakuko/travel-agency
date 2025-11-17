package com.protik.travel_agency.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
