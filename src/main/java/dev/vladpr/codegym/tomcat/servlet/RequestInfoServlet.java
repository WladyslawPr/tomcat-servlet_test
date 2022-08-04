package dev.vladpr.codegym.tomcat.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html");  // HTML 5
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            String title = "Title";
            out.println("<head><title>" + title + "</title></head>");
            out.println("<body>");
            out.println("<h3>" + title + "</h3>");

            // Tabulate the request information
            out.println("<table>");
            out.println("<tr><td> Protocol </td>");
            out.println("<td>" + request.getProtocol() + "</td></tr>");
            out.println("<tr><td>Method</td>");
            out.println("<td>" + request.getMethod() + "</td></tr>");
            out.println("</td></tr><tr><td>");
            out.println("<tr><td>URI</td>");
            out.println("<td>" + filter(request.getRequestURI()) + "</td></tr>");
            out.println("<tr><td>Path info</td>");
            out.println("<td>" + filter(request.getPathInfo()) + "</td></tr>");
            out.println("<tr><td>Path Translated:</td>");
            out.println("<td>" + request.getPathTranslated() + "</td></tr>");
            out.println("<tr><td>remote addres</td>");
            out.println("<td>" + request.getRemoteAddr() + "</td></tr>");

            String cipherSuite = (String) request.getAttribute("javax.servlet.request.cipher_suite");
            if (cipherSuite != null) {
                out.println("<tr><td>SSLCipherSuite:</td>");
                out.println("<td>" + cipherSuite + "</td></tr>");
            }
            out.println("</table></body></html>");
        }
        // Always close the output writer
    }

    public static String filter(String message) {
        if (message == null) return null;
        int len = message.length();
        StringBuilder result = new StringBuilder(len + 20);
        char aChar;

        for (int i = 0; i < len; ++i) {
            aChar = message.charAt(i);
            switch (aChar) {
                case '<': result.append("&lt;"); break;
                case '>': result.append("&gt;"); break;
                case '&': result.append("&amp;"); break;
                case '"': result.append("&quot;"); break;
                default:  result.append(aChar);
            }
        }
        return (result.toString());
    }


}
