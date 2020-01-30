package com.mlpk;

import com.mlpk.repos.PackageRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreatePackageServlet", urlPatterns = {"/createPackage"})
public class CreatePackageServlet extends HttpServlet {
    private final PackageRepository mPackageRepo;

    public CreatePackageServlet() {
        mPackageRepo = new PackageRepository();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String language = req.getParameter("language");
// set userForm value to user object.
        HttpSession session = req.getSession(true);
        if(session==null){
            req.setAttribute("error", "Only logged in users can create packages.");
            try {
                req.getRequestDispatcher("index.jsp").forward(req, res);
                return;
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        Long userId = (Long) session.getAttribute("userId");
        boolean ok = mPackageRepo.createPackage(userId, name, language);
        if(!ok){
            req.setAttribute("error", "Your package could not be created");
            try {
                req.getRequestDispatcher("index.jsp").forward(req, res);
                return;
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        res.sendRedirect("index.jsp");
    }

}
