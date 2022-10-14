package cn.acdt.study.day23.action;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static cn.acdt.study.day23.action.FileUpload.fileUpload;

/**
 * @author zzwtsy
 */
@WebServlet(name = "helloServlet", value = {"/hello-servlet"})
@MultipartConfig
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.getRequestDispatcher("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        Part part = request.getPart("uploadImg");
        String fileUploadPath = fileUpload(part, request);
        request.setAttribute("userName", userName);
        request.setAttribute("fileUploadPath", fileUploadPath);
        request.getRequestDispatcher("upload-status.jsp").forward(request, response);
    }
}