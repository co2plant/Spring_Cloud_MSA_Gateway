package kr.co.inntavern.spring_cloud_msa_gateway.component;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class G1Filter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain){
        System.out.println("pre global filter order -1");

        return gatewayFilterChain.filter(serverWebExchange).then(Mono.fromRunnable(() -> {
            System.out.println("post global filter order -1");
        }));
    }

    @Override
    public int getOrder(){
        return -1;
    }
}
