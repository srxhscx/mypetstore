package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddItemToCartServletPro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("workingItemId");
        HttpSession session = req.getSession();
        session.setAttribute("add",id);
        resp.sendRedirect("addItemToCart");
    }


}
