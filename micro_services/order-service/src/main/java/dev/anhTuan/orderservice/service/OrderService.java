package dev.anhTuan.orderservice.service;

import dev.anhTuan.orderservice.dto.OrderLineItemsDTO;
import dev.anhTuan.orderservice.dto.OrderRequest;
import dev.anhTuan.orderservice.model.Order;
import dev.anhTuan.orderservice.model.OrderLineItems;
import dev.anhTuan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDTOS()
                .stream()
                .map(this::mapToDTO).toList();
        order.setOrderLineItemsList(orderLineItemsList);
       orderRepository.save(order);

    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        return orderLineItems;
    }

}
