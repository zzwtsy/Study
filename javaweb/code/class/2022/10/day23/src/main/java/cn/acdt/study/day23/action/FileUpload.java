package cn.acdt.study.day23.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author zzwtsy
 */
public class FileUpload {
    public static String fileUpload(Part part, HttpServletRequest request) {
        String path = null;
        String filename = getFilename(part);
        if ("".equals(filename)) {
            return "文件上传失败";
        }
        String fileExtName = getFileExtName(part);
        String newFileName = System.currentTimeMillis() + fileExtName;
        String savePath = request.getServletContext().getRealPath("/img");
        File file = new File(savePath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                System.err.println("图片保存目录创建失败");
            }
        }
        try {
            path = savePath + File.separator + newFileName;
            part.write(path);
        } catch (IOException e) {
            System.err.println("文件保存失败:" + e.getMessage());
        }
        return path;
    }

    /**
     * 获取文件扩展名
     */
    private static String getFileExtName(Part part) {
        return "." + getHeaderContent(part, "\\.");
    }

    /**
     * 获取文件名
     */
    private static String getFilename(Part part) {
        return getHeaderContent(part, "=");
    }

    /**
     * 获取Header内容
     */
    public static String getHeaderContent(Part part, String value) {
        String header = part.getHeader("content-disposition");
        String[] tmp1 = header.split(";");
        String tmp2 = tmp1[tmp1.length - 1];
        String[] tmp3 = tmp2.split(value);
        return tmp3[tmp3.length - 1].replace("\"", "");
    }

}
