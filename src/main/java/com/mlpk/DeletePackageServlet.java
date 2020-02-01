package com.mlpk;

import com.mlpk.repos.PackageRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeletePackageServlet", urlPatterns = {"/DeletePackage"})
public class DeletePackageServlet extends HttpServlet {

    private final PackageRepository pkgRepo;

    public DeletePackageServlet(){
        pkgRepo = new PackageRepository();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pkgid = Integer.parseInt(request.getParameter("id"));
        HttpSession sess = request.getSession(true);
        Long userId = (Long)sess.getAttribute("userId");
        boolean deleted = pkgRepo.DeletePackage(pkgid, userId);
        if(!deleted){
            request.setAttribute("error", "Could not delete package.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        response.sendRedirect(request.getHeader("referer"));
    }
}
