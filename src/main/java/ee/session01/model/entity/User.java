package ee.session01.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@Entity(name = "userEntity01")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,16}$", message = "Invalid username")
    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,12}$", message = "Invalid password")
    @Column(name = "password", nullable = false, length = 12)
    private String password;

}
