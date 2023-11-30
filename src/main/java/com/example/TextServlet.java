package com.example;

import com.example.model.HibernateUtil;
import com.example.model.Watch;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "example", value = "/example")
public class TextServlet extends HttpServlet {

    private Double price;
    private List<Watch> watches;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        watches = session.createQuery("FROM Watch order by id asc", Watch.class).list();
        transaction.commit();
        session.close();
        request.setAttribute("watches", watches);
        getServletContext().getRequestDispatcher("/watches.jsp").forward(request, response); //переадресация на страницу
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mechPrice = request.getParameter("mechPrice");
        if(mechPrice!=null && !mechPrice.isEmpty()){
            Double price = Double.valueOf(mechPrice);
            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            watches = session
                    .createQuery("FROM Watch w WHERE w.price <= :price order by w.id asc ", Watch.class)
                    .setParameter("price", price)
                    .list();
            transaction.commit();
            session.close();
        } else {
            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            watches = session.createQuery("FROM Watch order by id asc ", Watch.class).list();
            transaction.commit();
            session.close();
        }

        request.setAttribute("watches", watches);

        request.getRequestDispatcher("/watches.jsp").forward(request, response);
    }
}