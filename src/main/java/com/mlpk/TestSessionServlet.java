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

@WebServlet(name = "TestSessionServlet", urlPatterns = {"/TestSessionServlet"})
public class TestSessionServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSessionServlet() {
        super();
        System.out.println("TestSessionServlet constructor called");
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("TestSessionServlet \"Init\" method called");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("TestSessionServlet \"Destroy\" method called");
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestSessionServlet doGet method called");
        //Get the exisiting session, if session doesn't exist it will return null
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        if(session!=null)
        {
            //get the attributes from session
            String uname=(String) session.getAttribute("user");
            System.out.println("Username and email id is retrived from the session");
            out.write("<html><body><h1>Username in session is "+uname +"</h1></body></html>");

        }
        else{
            //session not present(session=null)
            out.write("<html><body><h1>You're not logged in</h1></body></html>");
        }
        out.write("<html><body></body></html>");
    }
}
