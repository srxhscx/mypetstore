package csu.web.mypetstore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditeAccountFormServlet extends HttpServlet {

    private static final String EDITE_ACCOUNT_FORM ="/WEB-INF/jsp/account/EditeAccount.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(EDITE_ACCOUNT_FORM).forward(req,resp);
    }
}
