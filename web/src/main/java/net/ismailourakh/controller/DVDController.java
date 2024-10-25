package net.ismailourakh.web.controller;

import net.ismailourakh.ejb.DVDService;
import net.ismailourakh.entity.DVD;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dvd")
public class DVDController extends HttpServlet {

    @EJB
    private DVDService dvdService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteDVD(request, response);
                break;
            default:
                listDVDs(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertDVD(request, response);
        } else if ("update".equals(action)) {
            updateDVD(request, response);
        }
    }

    private void listDVDs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DVD> dvdList = dvdService.findAll();
        request.setAttribute("dvdList", dvdList);
        request.getRequestDispatcher("/dvdList.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/dvdForm.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DVD dvd = dvdService.find(id);
        request.setAttribute("dvd", dvd);
        request.getRequestDispatcher("/dvdForm.jsp").forward(request, response);
    }

    private void insertDVD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));

        DVD newDVD = new DVD(title, genre, year);
        dvdService.save(newDVD);
        response.sendRedirect("dvd?action=list");
    }

    private void updateDVD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));

        DVD updatedDVD = new DVD(id, title, genre, year);
        dvdService.update(updatedDVD);
        response.sendRedirect("dvd?action=list");
    }

    private void deleteDVD(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dvdService.delete(id);
        response.sendRedirect("dvd?action=list");
    }
}
