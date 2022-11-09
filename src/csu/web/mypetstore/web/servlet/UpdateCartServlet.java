package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class UpdateCartServlet extends HttpServlet {

    private static final String CART_FORM = "WEB-INF/jsp/cart/cart.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从对话中，获取购物车
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();

        while (cartItemIterator.hasNext()) {
            //产品数量增加
            CartItem cartItem = (CartItem) cartItemIterator.next();
            String itemId = cartItem.getItem().getItemId();

            try {
                int quantity = Integer.parseInt((String) req.getParameter("quantity"));
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItemIterator.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        session.setAttribute("cart", cart);

        Cart cart2 = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItemIterator2 = cart2.getAllCartItems();
        String quantityAll = "";
        while (cartItemIterator2.hasNext()) {
            //产品数量增加
            CartItem cartItem2 = cartItemIterator2.next();
            int quantity2 = cartItem2.getQuantity();
            quantityAll += quantity2 + "," + cartItem2.getTotal() + "," + cart2.getSubTotal();
        }
        resp.setContentType("text/xml");
        PrintWriter out = resp.getWriter();
        out.write(quantityAll);
    }
}