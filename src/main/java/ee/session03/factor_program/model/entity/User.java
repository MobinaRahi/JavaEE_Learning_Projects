package ee.session03.factor_program.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@NamedQueries({
        @NamedQuery(name = "User.findByUsername",query = "select u from userEntity u where u.username=:username"),
        @NamedQuery(name = "User.findByUsernameAndPassword",query = "select u from userEntity u where u.username=:username and u.password=:password"),
        @NamedQuery(name = "User.findAll",query = "select u from userEntity u ")
})

@Entity(name = "userEntity")
@Table(name = "users")
public class User {
    public final static String FIND_BY_USERNAME="User.findByUsername";
    public final static String FIND_BY_USERNAME_AND_PASSWORD="User.findByUsernameAndPassword";
    public final static String FIND_ALL="User.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,16}$", message = "Invalid username")
    @Column(name = "username", nullable = false, unique = true, length = 16)
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,12}$", message = "Invalid password")
    @Column(name = "password", nullable = false, length = 12)
    private String password;

    @ToString.Exclude
    @ManyToOne
    private Role role;

    @ToString.Exclude
    @OneToMany
    private List<Order> orderList;

}
