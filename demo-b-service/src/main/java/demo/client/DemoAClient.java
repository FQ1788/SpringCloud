package demo.client;

import demo.bean.DemoA;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "demo-a-service")
public interface DemoAClient {

    @RequestMapping("/getData")
    List<DemoA> getData();
    
    @RequestMapping("/index")
    String index();
}
