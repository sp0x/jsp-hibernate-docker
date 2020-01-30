package com.mlpk;

import com.mlpk.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private final UserRepository mUserRepo;

    public RegisterServlet(){
        mUserRepo = new UserRepository();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password= req.getParameter("password");
// set userForm value to user object.
        mUserRepo.saveUser(username, password);
        resp.sendRedirect("index.jsp");
    }
}
