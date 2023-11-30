package com.example;

import com.example.model.HibernateUtil;
import com.example.model.Manufacturer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;

@WebServlet(name = "DeleteMServlet", value = "/deleteM")
public class DeleteMServlet extends HttpServlet {

    private Long id;
    private Manufacturer m;
    private String idParam;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idParam = request.getParameter("id");
        if (idParam != null) {
            id = Long.parseLong(idParam);

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            m = session.get(Manufacturer.class, id);
            transaction.commit();
            session.close();

            request.setAttribute("name", m.getName());
            request.setAttribute("country", m.getCountry());

        } else {
            request.setAttribute("title", "Добавление");
        }


        request.getRequestDispatcher("/deleteM.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(m);
        transaction.commit();
        session.close();
        response.sendRedirect("/brand");
    }
}