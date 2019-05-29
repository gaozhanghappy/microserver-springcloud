package springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope  //开启refresh机制
public class ConfigClientApplication {
	@Value("${clientParam}")
	private String clientParam;
	@RequestMapping("/clientParam")
	public String getClientParam(){
		return this.clientParam;
	}
	@RequestMapping("/hello")
	public String hello(){
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
