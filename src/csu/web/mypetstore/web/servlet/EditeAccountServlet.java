package csu.web.mypetstore.web.servlet;

import com.mysql.cj.Session;
import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.AccountService;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditeAccountServlet extends HttpServlet {

    private static final String EDITE_ACCOUNT_FORM ="/WEB-INF/jsp/account/EditeAccount.jsp";

    Account oldAccount;

    private String username;
    private String password;
    private String repeatedPassword;
    private String firstName;
    private String lastName;
    private String Email;
    private String Phone;
    private String address1;
    private String address2;
    private String City;
    private String State;
    private String Zip;
    private String Country;
    private String languagePreference;
    private String favouriteCategoryId;
    private boolean listOption;
    private boolean bannerOption;

    private String message;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpsession = req.getSession();
        oldAccount =(Account) httpsession.getAttribute("loginAccount");
        this.username = req.getParameter("username");
        this.password = req.getParameter("password");
        this.repeatedPassword = req.getParameter("repeatPassword");
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
        if(!validate()){
            req.setAttribute("errorMSG",this.message);
            req.getRequestDispatcher(EDITE_ACCOUNT_FORM).forward(req,resp);
        }else{
            if(req.getParameter("listOption")!=null){
                if(req.getParameter("listOption").equals("1")){
                    oldAccount.setListOption(true);
                }else if(req.getParameter("listOption").equals("0")){
                    oldAccount.setListOption(false);
                }
            }
            System.out.println(req.getParameter("listOption"));
            if(req.getParameter("bannerOption")!=null){
                if(req.getParameter("bannerOption").equals("1")){
                    oldAccount.setBannerOption(true);
                }else if(req.getParameter("bannerOption").equals("0")){
                    oldAccount.setBannerOption(false);
                }
            }
            System.out.println(req.getParameter("bannerOption"));
            AccountService accountService = new AccountService();
            accountService.updateAccount(oldAccount);
            httpsession.setAttribute("loginAccount", oldAccount);
            resp.sendRedirect("mainForm");
        }
    }

    private boolean validate(){
        if(this.username == null || this.username.equals("")){
            message = "用户名不能为空";
            return false;
        }else if(!this.username.equals(oldAccount.getUsername())){
            oldAccount.setUsername(username);
        }
        if(this.password != null && !this.password.equals("")){
            if(this.repeatedPassword == null || this.repeatedPassword.equals("")){
                message = "请再输入一遍密码";
                return false;
            }
            if(!repeatedPassword.equals(password)){
                message = "两次输入不同";
                return false;
            }else{
                oldAccount.setPassword(password);
            }
        }
        if (this.firstName != null && !this.firstName.equals("") && !this.firstName.equals(oldAccount.getFirstName())){
            oldAccount.setFirstName(firstName);
        }
        if (this.lastName != null && !this.lastName.equals("") && !this.lastName.equals(oldAccount.getLastName())){
            oldAccount.setLastName(lastName);
        }
        if (this.Email != null && !this.Email.equals("") && !this.Email.equals(oldAccount.getEmail())){
            if (!this.Email.matches("[\\w]+@[\\w]+.[\\w]+[\\w]")) {
                message = "请输入有效的邮箱地址";
                return false;
            }else{
                oldAccount.setEmail(Email);
            }
        }
        if (this.Phone != null && !this.Phone.equals("") && !this.Phone.equals(oldAccount.getPhone())){
            if (!this.Phone.matches("^([0-9]{3}-?[0-9]{8}|[0-9]{4}-?[0-9]{7})$")){
                message = "请输入有效的电话号码";
                return false;
            }else{
                oldAccount.setPhone(Phone);
            }
        }
        if (this.address1 != null && !this.address1.equals("") && !this.address1.equals(oldAccount.getAddress1())){
            oldAccount.setAddress1(address1);
        }
        if (this.address2 != null && !this.address2.equals("") && !this.address2.equals(oldAccount.getAddress2())){
            oldAccount.setAddress2(address2);
        }
        if (this.City != null && !this.City.equals("") && !this.City.equals(oldAccount.getCity())){
            oldAccount.setCity(City);
        }
        if (this.State != null && !this.State.equals("") && !this.State.equals(oldAccount.getState())){
            oldAccount.setState(State);
        }
        if (this.Zip != null && !this.Zip.equals("") && !this.Zip.equals(oldAccount.getZip())){
            oldAccount.setZip(Zip);
        }
        if (this.Country != null && !this.Country.equals("") && !this.Country.equals(oldAccount.getCountry())){
            oldAccount.setCountry(Country);
        }
        if (this.languagePreference != null && !this.languagePreference.equals("") && !this.languagePreference.equals(oldAccount.getLanguagePreference())){
            oldAccount.setLanguagePreference(languagePreference);
        }
        if (this.favouriteCategoryId != null && !this.favouriteCategoryId.equals("") && !this.favouriteCategoryId.equals(oldAccount.getFavouriteCategoryId())){
            oldAccount.setFavouriteCategoryId(favouriteCategoryId);
            oldAccount.setBannerName("<image src=\"images/banner_"+favouriteCategoryId.toLowerCase()+".gif\">");
        }
        return true;
    }


}
