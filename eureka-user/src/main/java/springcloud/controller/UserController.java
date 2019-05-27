package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thinkpad on 2019/5/24.
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findOrderByUser/{id}")
    public String findOrderByUser(@PathVariable String id){
        System.out.println(121);
        return this.restTemplate.getForObject("http://eurekaorder/order/"+id,String.class);
    }
}
