package csu.web.mypetstore.web.servlet;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewAccountServlet extends HttpServlet {

    private static final String NEW_ACCOUNT_FORM = "WEB-INF/jsp/account/NewAccount.jsp";

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

    private String emailCode;
    private String emailCaptcha = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.emailCode =(String) req.getSession().getAttribute("EmailCode");
        this.emailCode = req.getParameter("emailCaptcha");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("一"+this.emailCode+"二"+emailCaptcha);
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
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
        if(!validate()){
            req.setAttribute("NewAccountMSG",this.message);
            req.getSession().setAttribute("loginAccount",newAccount);
            req.getRequestDispatcher(NEW_ACCOUNT_FORM).forward(req,resp);
        }else{
            AccountService accountService = new AccountService();
            accountService.insertAccount(newAccount);
            req.getSession().setAttribute("password",this.password);
            req.getSession().setAttribute("username",this.username);
            resp.sendRedirect("mainForm");
        }
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
        account.setBannerName("<image src=\"images/banner_"+this.favouriteCategoryId.toLowerCase()+".gif\">");
        account.setStatus("OK");
        account.setRepeatedPassword(repeatedPassword);
        return account;
    }

    private boolean validate(){
        if(this.username == null || this.username == ""){
            message = "用户名不能为空";
            return false;
        }
        if(this.password == null || this.password == ""){
            message = "密码不能为空";
            return false;
        }
        if (this.repeatedPassword == null || this.repeatedPassword == ""){
            message = "请输入两遍密码";
            return false;
        }
        if (!this.repeatedPassword.equals(password)){
            message = "两次密码输入不同";
            return false;
        }
        if (this.firstName == null || this.firstName == ""){
            message = "请输入名字";
            return false;
        }
        if (this.lastName == null || this.lastName == ""){
            message = "请输入姓氏";
            return false;
        }
        if (this.Email == null || this.Email == ""){
            message = "请输入邮箱";
            return false;
        }
        if (!this.Email.matches("[\\w]+@[\\w]+.[\\w]+[\\w]")) {
            message = "请输入有效的邮箱地址";
            return false;
        }
        if (this.Phone == null || this.Phone == ""){
            message = "请输入电话号码";
            return false;
        }
        if (!this.Phone.matches("^([0-9]{3}-?[0-9]{8}|[0-9]{4}-?[0-9]{7})$")){
            message = "请输入有效的电话号码";
            return false;
        }
        if (this.address1 == null || this.address1 == ""){
            message = "请输入第一地址";
            return false;
        }
        if (this.address2 == null || this.address2 == ""){
            message = "请输入第二地址";
            return false;
        }
        if (this.City == null || this.City == ""){
            message = "请输入所在城市";
            return false;
        }
        if (this.State == null || this.State == ""){
            message = "请输入所在地区";
            return false;
        }
        if (this.Zip == null || this.Zip == ""){
            message = "请输入邮编";
            return false;
        }
        if (this.Country == null || this.Country == ""){
            message = "请输入所在国家";
            return false;
        }
        if (this.languagePreference == null || this.languagePreference == ""){
            message = "请输入您使用的语言";
            return false;
        }
        if (this.favouriteCategoryId == null || this.favouriteCategoryId == ""){
            message = "请输入您的动物偏好";
            return false;
        }
        if (this.emailCaptcha == null ||this.emailCaptcha == ""){
            message = "请输入验证码";
            return false;
        }
        if (!this.emailCode.equals(emailCaptcha)){
            message = "验证码输入错误";
            return false;
        }
        return true;
    }
}
