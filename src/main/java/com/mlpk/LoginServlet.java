package com.mlpk;

import com.mlpk.models.User;
import com.mlpk.repos.UserRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserRepository mUserRepo;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        System.out.println("FirstServlet Constructor called!");
        mUserRepo = new UserRepository();
    }

    /**
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstServlet \"Init\" method called");
    }

    /**
     */
    public void destroy() {
        System.out.println("FirstServlet \"Destroy\" method called");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FirstServlet \"Service\" method(inherited) called");
        System.out.println("FirstServlet \"DoGet\" method called");
        response.sendRedirect("login.jsp");
        //storeInSessionAndRespond(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FirstServlet \"Service\" method(inherited) called");
        System.out.println("FirstServlet \"DoPost\" method called");

        storeInSessionAndRespond(request, response);

    }

    private void storeInSessionAndRespond(HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("Username from jsp page is "+ username);
        //Create a session
        HttpSession session = request.getSession(true);
        boolean couldntLogin = false;
        String error = null;
        if(session!=null)
        {
            String encpwd = Encryption.encrypt(password);
            User user = mUserRepo.login(username, encpwd);
            if(user!=null){
                //store the attributes
                session.setAttribute("user", username);
                session.setAttribute("userId", user.getId());
                System.out.println("Username and email id is stored in the session");
            }else{
                error = "Your password or username were wrong";
                couldntLogin = true;
            }
        }else{
            //We already have a session initialized.
        }
        if (error!=null) {
            request.setAttribute("error", error);
            try {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }else{
            try {
                request.setAttribute("username", username);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }


}

