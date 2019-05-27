package springcloud.conreoller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by thinkpad on 2019/5/27.
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findOrderByUser/{id}")
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    public String findOrderByUser(@PathVariable String id){
        return this.restTemplate.getForObject("http://EUREKAORDER/order/"+id,String.class);
    }
    public String fallbackInfo(@PathVariable String id){
        return "服务不可用，稍后再试";
    }
}
