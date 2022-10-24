package cn.acdt.hwk.day23.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 显示购物车商品
 *
 * @author zzwtsy
 * @date 2022-10-22
 */
@WebServlet("/ShowShoppingCart")
public class ShowShoppingCart extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<String> carts = (ArrayList<String>) request.getSession().getAttribute("carts");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        for (String o : carts) {
            writer.println(o);
        }
        writer.flush();
    }
}
