/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author quang
 */
@WebServlet(name = "LogServlet", urlPatterns = {"/log"})
public class LogServlet extends HttpServlet {

    private static final long serialVersionUID = 7503953988166684851L;

    public LogServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Path path = FileSystems.getDefault()
                .getPath("/path/to/tomcat/logs", "catalina.out");
        StringBuilder logContent = new StringBuilder();
        logContent.append("<pre>");
        try ( BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                logContent.append(line).append("<br/>");
            }
        } catch (IOException x) {
            // Take care of that 
        }
        logContent.append("</pre>");
        resp.getWriter().print(logContent.toString());
    }
}
