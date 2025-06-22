package com.example.ez_drive.dto.entities;

import com.example.ez_drive.models.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

}
