package itat.zttc.shop.web;

import itat.zttc.shop.model.SystemContext;

import javax.servlet.*;
import java.io.IOException;

public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try {
			int pageOffset = 0;
			int pageSize = 5;
			String sort = req.getParameter("sort");
			String order = req.getParameter("order");
			try {
				pageOffset = Integer.parseInt(req.getParameter("pager.offset"));
			} catch (NumberFormatException e) {
			}
			SystemContext.setOrder(order);
			SystemContext.setSort(sort);
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(pageSize);
			//SystemContext.setRealpath(RequestUtil.PATH);
			chain.doFilter(req, resp);
		} finally {
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeOrder();
			SystemContext.removeSort();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
