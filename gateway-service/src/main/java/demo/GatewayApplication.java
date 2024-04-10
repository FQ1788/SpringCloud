package demo;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);
    
    @Autowired
    RouteDefinitionLocator locator;
    
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 設定 OpenApi 的群組內容，將 Router 內各自微服務的 OpenApi 整合成各自的群組並顯示。
     * @return List<GroupedOpenApi> OpenApi群組的資料
     */
    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        
        definitions.stream()
            .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
            .forEach(routeDefinition -> {
                LOG.info("RouteDefinition ID : {}", routeDefinition.getId());
                String name = routeDefinition.getId().replace("-service", "");
                groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
            });
        
        return groups;
    }
}
