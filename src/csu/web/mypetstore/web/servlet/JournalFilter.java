package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Category;
import csu.web.mypetstore.domain.Journal;
import csu.web.mypetstore.persistence.JournalDAO;
import csu.web.mypetstore.persistence.impl.JournalDaoImpl;

import javax.imageio.spi.ServiceRegistry;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.LogRecord;

public class JournalFilter implements Filter {

    public void  init(FilterConfig config) throws ServletException {
            // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest)req;
        HttpSession session=httpReq.getSession();
        Category category=(Category)session.getAttribute("category");
        Account account=(Account) session.getAttribute("loginAccount");
        JournalDAO journalDAO=new JournalDaoImpl();
        if(account!=null){
            Journal journal=new Journal(account.getUsername(),httpReq.getQueryString(),httpReq.getRequestURL().toString(),new Date(System.currentTimeMillis()).toString());
            try {
                journalDAO.write(journal);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("状态");
            System.out.println(account.getUsername());
            System.out.println(new Date(System.currentTimeMillis()));
            System.out.println(httpReq.getRequestURL());
            System.out.println(httpReq.getQueryString());

        }
        chain.doFilter(req,resp);
    }

}
