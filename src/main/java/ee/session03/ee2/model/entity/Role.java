package ee.session03.ee2.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@Entity(name = "roleEntity03")
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String displayName;

    @ToString.Exclude
    @OneToMany(mappedBy = "role")
    private List<User> userList;

    public void addUser(User user) {
        userList.add(user);
    }
}
