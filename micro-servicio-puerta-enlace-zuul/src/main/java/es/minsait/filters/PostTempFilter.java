package es.minsait.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTempFilter extends ZuulFilter {

	/*
	 * Activar o desactivar filtro
	 * @return true se activa
	 * @return false lo ignora
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*
	 * Todo lo que quiero que ejecute el filtro
	 */
	@Override
	public Object run() throws ZuulException {
		// obtener el tiempo final
		Long endTime = System.currentTimeMillis();
		
		// recuperamos el tiempo de inicio del atributo de la request
		RequestContext ctx = RequestContext.getCurrentContext();
		Long startupTime = (Long) ctx.getRequest().getAttribute("startupTime");

		// mostrar la diferencia de tiempos
		System.out.println("****************************");
		System.out.println("Tiempo transcurrido: " + (endTime - startupTime) + " mseg");
		System.out.println("****************************");
		
		return null;
	}

	/*
	 * Devolver uno de estos valores:
	 * pre -> antes
	 * post -> despues
	 * route -> mientras
	 */
	@Override
	public String filterType() {
		return "post";
	}

	/*
	 * Orden de ejecucion del filtro en caso de tener mas de uno
	 */
	@Override
	public int filterOrder() {
		return 1; //1, 2...
	}

}
