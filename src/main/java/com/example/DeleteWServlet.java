package com.example;

import com.example.model.HibernateUtil;
import com.example.model.Manufacturer;
import com.example.model.Watch;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "DeleteWServlet", value = "/deleteW")
public class DeleteWServlet extends HttpServlet {

    private Long id;
    private Watch w;
    private String idParam;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idParam = request.getParameter("id");
        if (idParam != null) {
            id = Long.parseLong(idParam);

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            w = session.get(Watch.class, id);
            transaction.commit();
            session.close();

            request.setAttribute("id", w.getId());
            request.setAttribute("brand", w.getBrand());
            request.setAttribute("type", w.getType());


        } else {
            request.setAttribute("title", "Добавление");
        }


        request.getRequestDispatcher("/deleteW.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(w);
        transaction.commit();
        session.close();
        response.sendRedirect("/example");

    }
}