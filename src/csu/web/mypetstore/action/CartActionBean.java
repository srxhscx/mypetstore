package csu.web.mypetstore.action;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

import csu.web.mypetstore.service.CatalogService;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;
import csu.web.mypetstore.domain.Cart;
import csu.web.mypetstore.domain.CartItem;
import csu.web.mypetstore.domain.Item;

@SessionScope
public class CartActionBean extends AbstractActionBean {
    private static final long serialVersionUID = -4038684592582714235L;
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String CHECK_OUT = "/WEB-INF/jsp/cart/Checkout.jsp";
    @SpringBean
    private CatalogService catalogService;
    private Cart cart = new Cart();
    private String workingItemId;

    public CartActionBean() {
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setWorkingItemId(String workingItemId) {
        this.workingItemId = workingItemId;
    }

    public Resolution addItemToCart() {
        if (this.cart.containsItemId(this.workingItemId)) {
            this.cart.incrementQuantityByItemId(this.workingItemId);
        } else {
            boolean isInStock = this.catalogService.isItemInStock(this.workingItemId);
            Item item = this.catalogService.getItem(this.workingItemId);
            this.cart.addItem(item, isInStock);
        }

        return new ForwardResolution("/WEB-INF/jsp/cart/Cart.jsp");
    }

    public Resolution removeItemFromCart() {
        Item item = this.cart.removeItemById(this.workingItemId);
        if (item == null) {
            this.setMessage("Attempted to remove null CartItem from Cart.");
            return new ForwardResolution("/WEB-INF/jsp/common/Error.jsp");
        } else {
            return new ForwardResolution("/WEB-INF/jsp/cart/Cart.jsp");
        }
    }

    public Resolution updateCartQuantities() {
        HttpServletRequest request = this.context.getRequest();
        Iterator cartItems = this.getCart().getAllCartItems();

        while(cartItems.hasNext()) {
            CartItem cartItem = (CartItem)cartItems.next();
            String itemId = cartItem.getItem().getItemId();

            try {
                int quantity = Integer.parseInt(request.getParameter(itemId));
                this.getCart().setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception var6) {
            }
        }

        return new ForwardResolution("/WEB-INF/jsp/cart/Cart.jsp");
    }

    public ForwardResolution viewCart() {
        return new ForwardResolution("/WEB-INF/jsp/cart/Cart.jsp");
    }

    public ForwardResolution checkOut() {
        return new ForwardResolution("/WEB-INF/jsp/cart/Checkout.jsp");
    }

    public void clear() {
        this.cart = new Cart();
        this.workingItemId = null;
    }
}

