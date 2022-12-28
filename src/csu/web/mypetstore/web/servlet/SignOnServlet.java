package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.AccountService;
import csu.web.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SignOnServlet extends HttpServlet {

    private static final String SIGNON_FORM = "WEB-INF/jsp/account/signon.jsp";

    private String username;
    private String password;
    private String piccode;
    private String captcha;

    private String message;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.username = req.getParameter("username");
            this.password = req.getParameter("password");
            this.piccode=(String) req.getSession().getAttribute("piccode");
            this.captcha=req.getParameter("captcha").toUpperCase();
            if(!validate1()){
                req.setAttribute("signOnMsg",this.message);
                req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
            }else{
                AccountService accountService = new AccountService();
                Account loginAccount = accountService.getAccount(username,password);
                if(loginAccount == null){
                    this.message = "用户名或密码错误";
                    req.setAttribute("signOnMsg",this.message);
                    req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
                }else{
                    loginAccount.setPassword(null);
                    HttpSession session = req.getSession();
                    session.setAttribute("loginAccount",loginAccount);
                    if(loginAccount.isListOption()){
                        CatalogService catalogService = new CatalogService();
                        List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
                        session.setAttribute("myList",myList);
                    }
                    resp.sendRedirect("mainForm");
                }
            }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.username =(String) req.getSession().getAttribute("username");
        this.password =(String) req.getSession().getAttribute("password");
        if(!validate2()){
            req.setAttribute("signOnMsg",this.message);
            req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
        }else {
            AccountService accountService = new AccountService();
            Account loginAccount = accountService.getAccount(username, password);
            if (loginAccount == null) {
                this.message = "用户名或密码错误";
                req.setAttribute("signOnMsg", this.message);
                req.getRequestDispatcher(SIGNON_FORM).forward(req, resp);
            } else {
                loginAccount.setPassword(null);
                HttpSession session = req.getSession();
                session.setAttribute("loginAccount", loginAccount);

                if (loginAccount.isListOption()) {
                    CatalogService catalogService = new CatalogService();
                    List<Product> myList = catalogService.getProductListByCategory(loginAccount.getFavouriteCategoryId());
                    session.setAttribute("myList", myList);
                }

                resp.sendRedirect("mainForm");
            }
        }
    }

    private boolean validate1(){
        if(this.username == null || this.username == ""){
            message = "用户名不能为空";
            return false;
        }
        if(this.password == null || this.password == ""){
            message = "密码不能为空";
            return false;
        }
        if(!captcha.equals(piccode)){
            message = "验证码错误";
            return false;
        }
        return true;
    }

    private boolean validate2(){
        if(this.username == null || this.username == ""){
            message = "用户名不能为空";
            return false;
        }
        if(this.password == null || this.password == ""){
            message = "密码不能为空";
            return false;
        }
        return true;
    }
}
