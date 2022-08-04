package dev.vladpr.codegym.tomcat.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HiWorldServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(HiWorldServlet.class);

    @Override
    public void destroy() {
        super.destroy();
        logger.info("HiWorldServlet was destroyed");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        logger.info("HiWorldServlet was initiated");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Results: {}", request);
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String title = "Hello Guys!";
            out.println("<!DOCTYPE html>");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>" + title + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + title + "</h1>");  // Prints "Hello, world!"
            out.println("<a href='" + request.getRequestURI() + "'><img src='images/return.jpeg'></a>");
            out.println("</body></html>");
        }
    }


}

