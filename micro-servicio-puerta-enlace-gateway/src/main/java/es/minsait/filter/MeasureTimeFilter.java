package es.minsait.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MeasureTimeFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// tiempo de inicio
		Long startupTime = System.currentTimeMillis();
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
					// tomar tiempo final
					Long endTime = System.currentTimeMillis();
					// mostrar diferencia
					System.out.println("****************************");
					System.out.println("Tiempo transcurrido: " + (endTime - startupTime) + " mseg");
					System.out.println("****************************");
				}));
	}
	
	@Override
	public int getOrder() {
		// en caso de tener varios filtros establecemos el orden de ejecucion
		return 1;
	}

}
