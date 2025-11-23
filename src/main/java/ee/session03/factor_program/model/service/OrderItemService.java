package ee.session03.factor_program.model.service;

import ee.session03.factor_program.model.entity.OrderItem;
import ee.session03.factor_program.model.repository.OrderItemRepository;


import java.util.List;
import java.util.Optional;


public class OrderItemService {
    public void SaveOrderItem(OrderItem orderItem) {
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        orderItemRepository.save(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem) {
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        orderItemRepository.update(orderItem);
    }

    public void deleteOrderItem(Integer id) {
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        orderItemRepository.delete(id);
    }

    public Optional<OrderItem> getOrderItem(Integer id) {
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getAllOrderItems() {
        OrderItemRepository orderItemRepository = new OrderItemRepository();
        return orderItemRepository.findAll();
    }

}
