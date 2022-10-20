package cn.acdt.study.action;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 另一个svl
 *
 * @author zzwtsy
 * @date 2022-10-20
 */
@WebServlet(value = "/hello")
public class AnotherSvl extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String id = session.getId();
        Object welcome = session.getAttribute("welcome");
        System.out.println(getClass());
        System.out.println(welcome);
        System.out.println(id);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
