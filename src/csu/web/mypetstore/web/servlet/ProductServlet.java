package csu.web.mypetstore.web.servlet;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonArray;
import csu.web.mypetstore.domain.CategoryDTO;
import csu.web.mypetstore.domain.Product;
import csu.web.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "product",urlPatterns = {"/productList"})
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId =req.getParameter("categoryId");

        List<CategoryDTO> categoryDTOList=new CatalogService().getProductListByCategory1(categoryId);
        String jsonString= JSON.toJSONString(categoryDTOList);
        resp.setContentType("text/plain");
        PrintWriter out=resp.getWriter();
        out.println(jsonString);
    }


}
