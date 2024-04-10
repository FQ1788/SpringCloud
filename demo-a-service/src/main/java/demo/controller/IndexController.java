package demo.controller;

import demo.bean.DemoA;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
    
    @RequestMapping("/index")
    public String index() {
        LOG.info("IN!!!!!!! Demo A index !!!!!!!");
        return "HELLO WORLD A";
    }
    
    @RequestMapping("/getData")
    public List<DemoA> getData() {
        List<DemoA> data = new ArrayList<>();
        data.add(new DemoA("1-2", "ddd", 2));
        data.add(new DemoA("144", "ggg", 7));
        data.add(new DemoA("152", "dbb", 9));
        data.add(new DemoA("1ss2dwad", "dsdd", 21));
        data.add(new DemoA("www", "ff", 300));
        data.add(new DemoA("ddff2", "rra", 413));
        return data;
    }
}
