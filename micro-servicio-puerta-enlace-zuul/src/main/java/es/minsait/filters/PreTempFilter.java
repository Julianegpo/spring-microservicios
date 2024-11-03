package es.minsait.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTempFilter extends ZuulFilter {

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
		// obtener el tiempo de inicio
		Long startupTime = System.currentTimeMillis();
		// lo guardo como atributo de peticion
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().setAttribute("startupTime", startupTime);
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
		return "pre";
	}

	/*
	 * Orden de ejecucion del filtro en caso de tener mas de uno
	 */
	@Override
	public int filterOrder() {
		return 1; //1, 2...
	}

}
