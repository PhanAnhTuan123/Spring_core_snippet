package dev.anhTuan.orderservice.service;

import dev.anhTuan.orderservice.dto.InventoryResponse;
import dev.anhTuan.orderservice.dto.OrderLineItemsDTO;
import dev.anhTuan.orderservice.dto.OrderRequest;
import dev.anhTuan.orderservice.model.Order;
import dev.anhTuan.orderservice.model.OrderLineItems;
import dev.anhTuan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDTOS()
                .stream()
                .map(this::mapToDTO).toList();
        order.setOrderLineItemsList(orderLineItemsList);

         List<String>skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

         // Call Inventory Service, and place order if prodcut is in
        // stock
        InventoryResponse[] inventoryResponseArray = webClient.build().get()
                .uri("http://localhost:8082/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        boolean allProductsInstock =  Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        if(allProductsInstock){
            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        return orderLineItems;
    }

}
