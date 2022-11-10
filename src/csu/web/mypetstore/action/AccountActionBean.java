package csu.web.mypetstore.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.AccountService;
import csu.web.mypetstore.service.CatalogService;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;


@SessionScope
public class AccountActionBean extends AbstractActionBean {
    private static final long serialVersionUID = 5499663666155758178L;
    private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccount.jsp";
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccount.jsp";
    private static final String SIGNON = "/WEB-INF/jsp/account/signon.jsp";
    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;
    @SpringBean
    private AccountService accountService;
    @SpringBean
    private CatalogService catalogService;
    private Account account = new Account();
    private List<Product> myList;
    private boolean authenticated;

    static {
        List<String> langList = new ArrayList();
        langList.add("english");
        langList.add("japanese");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);
        List<String> catList = new ArrayList();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");
        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }

    public AccountActionBean() {
    }

    public Account getAccount() {
        return this.account;
    }

    public String getUsername() {
        return this.account.getUsername();
    }

    @Validate(
            required = true,
            on = {"signon", "newAccount", "editAccount"}
    )
    public void setUsername(String username) {
        this.account.setUsername(username);
    }

    public String getPassword() {
        return this.account.getPassword();
    }

    @Validate(
            required = true,
            on = {"signon", "newAccount", "editAccount"}
    )
    public void setPassword(String password) {
        this.account.setPassword(password);
    }

    public List<Product> getMyList() {
        return this.myList;
    }

    public void setMyList(List<Product> myList) {
        this.myList = myList;
    }

    public List<String> getLanguages() {
        return LANGUAGE_LIST;
    }

    public List<String> getCategories() {
        return CATEGORY_LIST;
    }

    public Resolution newAccountForm() {
        return new ForwardResolution("/WEB-INF/jsp/account/NewAccountForm.jsp");
    }

    public Resolution newAccount() {
        this.accountService.insertAccount(this.account);
        this.account = this.accountService.getAccount(this.account.getUsername());
        this.myList = this.catalogService.getProductListByCategory(this.account.getFavouriteCategoryId());
        this.authenticated = true;
        return new RedirectResolution(CatalogActionBean.class);
    }

    public Resolution editAccountForm() {
        return new ForwardResolution("/WEB-INF/jsp/account/EditAccountForm.jsp");
    }

    public Resolution editAccount() {
        this.accountService.updateAccount(this.account);
        this.account = this.accountService.getAccount(this.account.getUsername());
        this.myList = this.catalogService.getProductListByCategory(this.account.getFavouriteCategoryId());
        return new RedirectResolution(CatalogActionBean.class);
    }

    @DefaultHandler
    public Resolution signonForm() {
        return new ForwardResolution("/WEB-INF/jsp/account/signon.jsp");
    }

//    public Resolution signon() {
//        this.account = this.accountService.getAccount(this.getUsername(), this.getPassword());
//        if (this.account == null) {
//            String value = "Invalid username or password.  Signon failed.";
//            this.setMessage(value);
//            this.clear();
//            return new ForwardResolution("/WEB-INF/jsp/account/signon.jsp");
//        } else {
//            this.account.setPassword((String)null);
//            this.myList = this.catalogService.getProductListByCategory(this.account.getFavouriteCategoryId());
//            this.authenticated = true;
//            HttpSession s = this.context.getRequest().getSession();
//            s.setAttribute("accountBean", this);
//            return new RedirectResolution(CatalogActionBean.class);
//        }
//    }

    public Resolution signoff() {
        this.context.getRequest().getSession().invalidate();
        this.clear();
        return new RedirectResolution(CatalogActionBean.class);
    }

//    public boolean isAuthenticated() {
//        return this.authenticated && this.account != null && this.account.getUsername() != null;
//    }

    public void clear() {
        this.account = new Account();
        this.myList = null;
        this.authenticated = false;
    }
}
