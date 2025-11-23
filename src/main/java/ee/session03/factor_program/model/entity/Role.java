package ee.session03.factor_program.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "select u from roleEntity u")
})
@Entity(name = "roleEntity")
@Table(name = "roles")
public class Role {
    public final static String FIND_ALL = "Role.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String displayName;

}
