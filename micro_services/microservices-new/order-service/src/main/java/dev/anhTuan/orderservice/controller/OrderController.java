package dev.anhTuan.orderservice.controller;

import dev.anhTuan.orderservice.dto.OrderRequest;
import dev.anhTuan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest ){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }

}
