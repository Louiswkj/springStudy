package com.imooc.mall.filter;

import com.imooc.mall.constant.MallConstant;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.MallUser;
import com.imooc.mall.service.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuliang
 * 2021/7/3
 */
public class AdminFilter implements Filter {
    @Autowired
    private MallUserService mallUserService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        MallUser currentUser = (MallUser) session.getAttribute(MallConstant.MALL_USER);
        if (currentUser == null) {
            PrintWriter printWriter = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            printWriter.write("{\n" +
                    "    \"status\": 10007,\n" +
                    "    \"message\": \"NEED_LOGIN\",\n" +
                    "    \"data\": null\n" +
                    "}");
            printWriter.flush();
            printWriter.close();
            return;
        }
        //校验是不是管理员
        Boolean isAdmin = mallUserService.checkAdmin(currentUser);
        if (isAdmin) {
            //是管理员执行操作
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            PrintWriter printWriter = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            printWriter.write("{\n" +
                    "    \"status\": 10008,\n" +
                    "    \"message\": \"NEED_ADMIN_LOGIN\",\n" +
                    "    \"data\": null\n" +
                    "}");
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override
    public void destroy() {

    }
}
