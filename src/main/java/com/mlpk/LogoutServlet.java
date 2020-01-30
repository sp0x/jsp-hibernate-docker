package com.mlpk;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = "/Logout")
public class LogoutServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        System.out.println("Logout servlet constructor called");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("LogoutServlet \"Init\" method called");
    }

    public void destroy() {
        System.out.println("LogoutServlet \"Destroy\" method called");
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        if(session!=null)
        {
            //invalidates the session
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        else{
            out.write("<html><body><h1>You're not logged in.</h1></body></html>");
        }
        out.write("<html><body></body></html>");
    }

}
