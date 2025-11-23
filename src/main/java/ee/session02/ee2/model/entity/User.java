package ee.session02.ee2.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@Entity(name = "userEntity02Plus")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,16}$", message = "Invalid username")
    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "Invalid password")
    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Invalid Name !!!")
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Invalid Family !!!")
    @Column(name = "family", length = 20, nullable = false)
    private String family;
}
