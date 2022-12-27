package csu.web.mypetstore.web.servlet;


import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.Consignee;
import csu.web.mypetstore.domain.Order;
import csu.web.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class NewOrderFormServlet extends HttpServlet {
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/newOrder.jsp";
    private static final String SIGNON_FORM = "/WEB-INF/jsp/account/signon.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Account account;
    private Order order;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        account = (Account)session.getAttribute("loginAccount");
        cart = (Cart)session.getAttribute("cart");

        if (account == null){
            session.setAttribute("message", "You must sign on before attempting to check out.  Please sign on and try checking out again.");
            request.getRequestDispatcher(SIGNON_FORM).forward(request, response);
        } else if(cart != null){
            String username = account.getUsername();
            AccountService accountService = new AccountService();
            List<Consignee> consigneeList = accountService.getConsignee(username);
            session.setAttribute("consigneeList",consigneeList);

            order = new Order();
            order.initOrder(account, cart);
            session.setAttribute("order", order);
            request.getRequestDispatcher(NEW_ORDER).forward(request, response);
        }else{
            session.setAttribute("message", "An order could not be created because a cart could not be found.");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
}
