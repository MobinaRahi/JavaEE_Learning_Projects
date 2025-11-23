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
        @NamedQuery(name = "Product.findAll", query = "select u from productEntity u"),
        @NamedQuery(name = "Product.findByName", query = "select u from productEntity u where u.name=:name")

}
)

@Entity(name = "productEntity")
@Table(name = "products")
public class Product {

    public static final String FIND_ALL = "Product.findAll";
    public static final String FIND_BY_NAME = "Product.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
}
