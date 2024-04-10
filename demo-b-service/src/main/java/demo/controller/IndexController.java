package demo.controller;

import demo.bean.DemoB;
import demo.client.DemoAClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private final DemoAClient demoAClient;
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    public IndexController(@Autowired DemoAClient demoAClient) {
        this.demoAClient = demoAClient;
    }
    
    @RequestMapping("/index")
    public String index() {
        String index = demoAClient.index();
        LOG.info("!!!!! demo B INDEX !!!!!");
        LOG.info("Demo A index: {}", index);
        return "HELLO B WORLD";
    }
    
    @RequestMapping("/getData")
    public DemoB getData() {
        DemoB demoB = new DemoB(2234, null);
        demoB.setData(demoAClient.getData());
        demoAClient.getData().forEach(i -> LOG.info("getDemoAName:{}" ,i.getName()));
        return demoB;
    }
}
