package ee.session03.ee2.model.entity;

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

@Entity(name = "userEntity03")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,16}$", message = "Invalid username")
    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,12}$", message = "Invalid password")
    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Invalid Name !!!")
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Invalid Family !!!")
    @Column(name = "family", length = 20, nullable = false)
    private String family;

    @ToString.Exclude
    @ManyToOne
    @JoinTable(name = "users_roles")
    private Role role;

    @Transient
    private String alaki;

}
