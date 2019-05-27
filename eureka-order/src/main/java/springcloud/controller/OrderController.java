package springcloud.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.model.Order;

/**
 * Created by thinkpad on 2019/5/24.
 */@RestController
public class OrderController {
    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable String id){
        System.out.println("order1");
        Order order=new Order(1,12.2,"lissi","qianqian","12345678900");
        return  order.toString();
    }
}
