package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewAccountFormServlet extends HttpServlet {
    private static final String NEW_ACCOUNT_FORM ="/WEB-INF/jsp/account/NewAccount.jsp";

    private String username = "";
    private String password = "";
    private String repeatedPassword = "";
    private String firstName = "";
    private String lastName = "";
    private String Email = "";
    private String Phone = "";
    private String address1 = "";
    private String address2 = "";
    private String City = "";
    private String State = "";
    private String Zip = "";
    private String Country = "";
    private String languagePreference = "";
    private String favouriteCategoryId = "";
    private boolean listOption;
    private boolean bannerOption;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.username = req.getParameter("username");
        this.password = req.getParameter("password");
        this.repeatedPassword = req.getParameter("repeatedPassword");
        this.firstName = req.getParameter("firstName");
        this.lastName = req.getParameter("lastName");
        this.Email = req.getParameter("email");
        this.Phone = req.getParameter("phone");
        this.address1 = req.getParameter("address1");
        this.address2 = req.getParameter("address2");
        this.City = req.getParameter("city");
        this.State = req.getParameter("state");
        this.Zip = req.getParameter("zip");
        this.Country = req.getParameter("country");
        this.languagePreference = req.getParameter("languagePreference");
        this.favouriteCategoryId = req.getParameter("favouriteCategoryId");
        this.repeatedPassword = req.getParameter("repeatedPassword");
        if(req.getParameter("listOption") != null && req.getParameter("listOption").equals("1")){
            this.listOption = true;
        }else {
            this.bannerOption = false;
        }
        if(req.getParameter("bannerOption") != null && req.getParameter("bannerOption").equals("1")){
            this.bannerOption = true;
        }else {
            this.bannerOption = false;
        }
        Account newAccount;
        newAccount = this.getAccount();
        req.getSession().setAttribute("errorAccount",newAccount);
        req.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(req,resp);
    }

    private Account getAccount(){
        Account account = new Account();
        account.setPassword(this.password);
        account.setBannerOption(this.bannerOption);
        account.setUsername(this.username);
        account.setListOption(this.listOption);
        account.setZip(this.Zip);
        account.setState(this.State);
        account.setPhone(this.Phone);
        account.setAddress1(this.address1);
        account.setAddress2(this.address2);
        account.setLanguagePreference(this.languagePreference);
        account.setLastName(this.lastName);
        account.setFirstName(this.firstName);
        account.setFavouriteCategoryId(this.favouriteCategoryId);
        account.setEmail(this.Email);
        account.setCountry(this.Country);
        account.setCity(this.City);
        account.setStatus("OK");
        account.setRepeatedPassword(this.repeatedPassword);
        return account;
    }
}
