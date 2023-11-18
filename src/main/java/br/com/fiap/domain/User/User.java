package br.com.fiap.domain.User;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String gender;
    private LocalDateTime birthdayDate;


}
