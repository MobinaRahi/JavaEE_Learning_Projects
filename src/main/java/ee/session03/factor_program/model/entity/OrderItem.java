package ee.session03.factor_program.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@NamedQueries({
        @NamedQuery(name = "OrderItem.findAll",query = "select u from orderItemEntity u")
})

@Entity(name = "orderItemEntity")
@Table(name = "order_items")
public class OrderItem {
    public static final String FIND_ALL = "OrderItem.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    private int price;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;
}
