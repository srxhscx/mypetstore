package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShippingFormServlet extends HttpServlet {
    private static final String SHIPPING_FORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String SIGNON_FORM = "/WEB-INF/jsp/account/signon.jsp";

    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        account = (Account)session.getAttribute("account");
        request.getRequestDispatcher(SHIPPING_FORM).forward(request, response);
//        if (account == null){
//            request.getRequestDispatcher(SIGNON_FORM).forward(request, response);
//        } else{
//            request.getRequestDispatcher(SHIPPING_FORM).forward(request, response);
//        }
    }
}
