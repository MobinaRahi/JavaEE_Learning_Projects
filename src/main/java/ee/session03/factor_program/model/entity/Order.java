package ee.session03.factor_program.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

@NamedQueries({
        @NamedQuery(name = "order.findAll",query = "select u from orderEntity u"),
        @NamedQuery(name = "order.findByTitle",query = "select u from orderEntity u where u.title=:tile")

})

@Entity(name = "orderEntity")
@Table(name = "orders")
public class Order {
    public static final String FIND_ALL = "Order.findAll";
    public static final String FIND_BY_TITLE = "Order.findByTitle";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDateTime orderTime;

    @ManyToOne
    private User customer;

    @ToString.Exclude
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList;

    public void addOrderItem(OrderItem orderItem) {
        if (this.orderItemList == null) {
            this.orderItemList = new ArrayList<>();
        }
        this.orderItemList.add(orderItem);
    }

    private int total=0;

    public int getTotal() {
        for (OrderItem orderItem : this.orderItemList) {
            total+=orderItem.getQuantity()*orderItem.getPrice();
        }
        return total;
    }
}
