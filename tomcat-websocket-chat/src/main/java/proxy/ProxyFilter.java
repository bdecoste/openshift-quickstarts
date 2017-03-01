package proxy;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ProxyFilter implements Filter {

	public ProxyFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		request.setAttribute("uri", req.getRequestURI().substring(req.getContextPath().length()));

		request.getRequestDispatcher("/ProxyServlet").forward(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
