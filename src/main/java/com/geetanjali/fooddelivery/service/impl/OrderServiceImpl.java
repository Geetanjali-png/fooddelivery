package com.geetanjali.fooddelivery.service.impl;

import com.geetanjali.fooddelivery.entity.Cart;
import com.geetanjali.fooddelivery.entity.CartItem;
import com.geetanjali.fooddelivery.entity.Order;
import com.geetanjali.fooddelivery.entity.OrderItem;
import com.geetanjali.fooddelivery.entity.User;
import com.geetanjali.fooddelivery.repository.CartItemRepository;
import com.geetanjali.fooddelivery.repository.CartRepository;
import com.geetanjali.fooddelivery.repository.OrderItemRepository;
import com.geetanjali.fooddelivery.repository.OrderRepository;
import com.geetanjali.fooddelivery.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            CartRepository cartRepository,
            CartItemRepository cartItemRepository) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Order createOrder(User user, String deliveryAddress) {

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));

        List<CartItem> cartItems =
                cartItemRepository.findByCart(cart);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();

        order.setUser(user);
        order.setDeliveryAddress(deliveryAddress);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(0.0);

        Order savedOrder = orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();

        double totalAmount = 0.0;

        for (CartItem cartItem : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(savedOrder);
            orderItem.setMenuItem(cartItem.getMenuItem());
            orderItem.setQuantity(cartItem.getQuantity());

            double price = cartItem.getMenuItem().getPrice();

            orderItem.setPrice(price);

            totalAmount += price * cartItem.getQuantity();

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        savedOrder.setTotalAmount(totalAmount);

        Order finalOrder = orderRepository.save(savedOrder);

        cartItemRepository.deleteAll(cartItems);

        return finalOrder;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {

        return orderRepository.findByUser(user);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {

        return orderRepository.findById(id);
    }
}