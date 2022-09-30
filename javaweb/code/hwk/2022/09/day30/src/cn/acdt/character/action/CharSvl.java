package cn.acdt.character.action;

import cn.acdt.character.biz.HelloBiz;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author 孟繁兴
 */
@WebServlet(urlPatterns = "/hello")
public class CharSvl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        1.获取欢迎信息2.传递欢迎信息到页面中，在页面中显示欢迎信息
        HelloBiz helloBiz = new HelloBiz();
        String helloMsg = helloBiz.sayHello("MFX");
//        req.setAttribute("message", helloMsg);
//        req.getRequestDispatcher("").forward(req, resp);
//        PrintWriter out = response.getWriter();
//        out.write("<!DOCTYPE html>\r");
//        out.write("<html>\r\n");
//        out.write("<body>\r\n");
//        out.print(helloMsg);
//        out.write("</body>\r\n");
//        out.write("</html>");
//        out.flush();
//        out.close();
        String picPath = request.getServletContext().getRealPath("/") + "pic/avatar.jpg";
        File picFile = new File(picPath);
        byte[] picData = FileUtils.readFileToByteArray(picFile);
        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html>\r\n");
        out.write("<html>\r\n");
        out.write("<body>\r\n");
        out.write(Arrays.toString(picData));
        out.write("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
