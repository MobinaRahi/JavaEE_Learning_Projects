package ee.session03.factor_program.model.service;

import ee.session03.factor_program.model.entity.Order;
import ee.session03.factor_program.model.repository.OrderRepository;

import java.util.List;
import java.util.Optional;


public class OrderService {
    public void SaveOrder(Order order) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.update(order);
    }

    public void deleteOrder(Integer id) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.delete(id);
    }

    public Optional<Order> getOrder(Integer id) {
        OrderRepository orderRepository = new OrderRepository();
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        OrderRepository orderRepository = new OrderRepository();
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderByTitle(String title) {
        OrderRepository orderRepository = new OrderRepository();
        return orderRepository.findByTitle(title);
    }
}
