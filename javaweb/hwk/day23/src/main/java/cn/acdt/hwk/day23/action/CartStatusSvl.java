package cn.acdt.hwk.day23.action;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 购物车状态svl
 *
 * @author 孟繁兴
 * @since 2022/11/20
 */
@Log4j2
@WebServlet(urlPatterns = "/CartStatusSvl")
public class CartStatusSvl extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ArrayList<String> sessionCarts = (ArrayList<String>) request.getSession().getAttribute("carts");
        ArrayList<String> carts;
        if (sessionCarts == null) {
            carts = new ArrayList<>();
        } else {
            carts = sessionCarts;
        }
        String[] goods = request.getParameterValues("goods");
        int num = 0;
        if (goods != null) {
            num = goods.length;
            Collections.addAll(carts, goods);
        }
        session.setAttribute("addGoodsNum", num);
        session.setAttribute("addGoodsTotal", carts.size());
        session.setAttribute("carts", carts);
        try {
            request.getRequestDispatcher("cart-status.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
