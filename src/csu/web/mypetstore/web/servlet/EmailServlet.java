package csu.web.mypetstore.web.servlet;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class EmailServlet extends HttpServlet {

    String stringBuilder ="";
    String Email = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Email = req.getParameter("email");
        if (!this.Email.matches("[\\w]+@[\\w]+.[\\w]+[\\w]")) {
            req.getSession().setAttribute("EmailCode",stringBuilder);
            req.getRequestDispatcher("NewAccountForm").forward(req, resp);
        }else{
            Properties prop = new Properties();
            // 开启debug调试，以便在控制台查看
            prop.setProperty("mail.debug", "true");
            // 设置邮件服务器主机名
            prop.setProperty("mail.host", "smtp.qq.com");
            // 发送服务器需要身份验证
            prop.setProperty("mail.smtp.auth", "true");
            // 发送邮件协议名称
            prop.setProperty("mail.transport.protocol", "smtp");
            // 开启SSL加密，否则会失败
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            // 创建session
            Session session = Session.getInstance(prop);
            // 通过session得到transport对象
            Transport ts = null;
            try {
                ts = session.getTransport();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }
            // 连接邮件服务器：邮箱类型，帐号，POP3/SMTP协议授权码 163使用：smtp.163.com
            try {
                ts.connect("smtp.qq.com", "3413637036", "drebdxclheimcica");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            // 创建邮件
            Message message = null;
            try {
                message = createSimpleMail(session);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 发送邮件
            try {
                ts.sendMessage(message, message.getAllRecipients());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                ts.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("EmailCode",stringBuilder);
            req.getRequestDispatcher("NewAccountForm").forward(req, resp);
        }

    }


    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public MimeMessage createSimpleMail(Session session) throws Exception {
        //  获取6为随机验证码
        String[] letters = new String[] {
                "q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
                "A","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
                "0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < 6; i++) {
            stringBuilder = stringBuilder + letters[(int)Math.floor(Math.random()*letters.length)];
        }

        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress("3413637036@qq.com"));
        // 指明邮件的收件人，发件人和收件人如果是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(Email));
        // 邮件的标题
        message.setSubject("JavaMail测试");
        // 邮件的文本内容
        message.setContent("欢迎您注册,账号注册验证码为(一分钟有效):"+stringBuilder+",请勿回复此邮箱", "text/html;charset=UTF-8");

        // 返回创建好的邮件对象
        return message;
    }
}
