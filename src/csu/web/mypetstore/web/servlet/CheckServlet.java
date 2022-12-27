package csu.web.mypetstore.web.servlet;

import com.mysql.cj.Session;
import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/check"},name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.print(req.getParameter("username"));
        String username = (String) req.getParameter("username");
        AccountService accountService = new AccountService();
        Account loginAccount = accountService.getAccount(username);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        if(loginAccount == null){
            resp.getWriter().write("{\"name\":\"no error\"}");
        }else{
            resp.getWriter().write("{\"name\":\"name\"}");
        }
    }
}
