package ee.session03.ee1.model.entity;

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

@NamedQueries({
        @NamedQuery(name = "User.FindByName",query = "select u from userEntity03 u where u.name=:name"),
        @NamedQuery(name = "User.FindByFamily",query = "select u from userEntity03 u where u.family=:family"),
})
public class User {
    public final static String FIND_BY_NAME_QUERY = "User.FindByName";

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

}
