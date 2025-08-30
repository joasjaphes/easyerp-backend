package com.jcom.easyerp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // safer than "user"
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id") // equality based on primary key
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( nullable = false, unique = true, length = 11)
    private String uid;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "middle_name", length = 50)
    private String middleName;
}
