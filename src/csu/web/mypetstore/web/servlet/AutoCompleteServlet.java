package csu.web.mypetstore.web.servlet;

import com.alibaba.fastjson.JSON;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author RongXing 1360908370@qq.com
 * @version 2022/12/19 18:34
 * @ since JDK11
 */
public class AutoCompleteServlet extends HttpServlet {

    String result;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        CatalogService catalogService = new CatalogService();
        List<Product> productList = catalogService.searchProductList(keyword);
        System.out.println("aaa");
        result = JSON.toJSONString(productList);
        //System.out.println(result);
        System.out.println("sss");
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();
        out.println(result);
    }
}
