package com.dapeng.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* 类描述：  网关编码配置类  也可以使用yml的方式
* @Author diaopengwei
* @Date 2022/2/28 8:50
**/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder ) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //访问localhost:9527/guonei将会访问 http://new.baidu.com/guonei
        routes.route("payt_route_dapeng",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
