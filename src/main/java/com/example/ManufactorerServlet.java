package com.example;

import com.example.model.HibernateUtil;
import com.example.model.Manufacturer;
import com.example.model.Watch;
import com.example.model.WatchType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "brand", value = "/brand")
public class ManufactorerServlet  extends HttpServlet {

    private List<String> types;

    private List<String> countries;
    private List<Manufacturer> manufacturers;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        manufacturers = session.createQuery("FROM Manufacturer order by id", Manufacturer.class).list();
        countries = session.createQuery("select m.country from Manufacturer m group by m.country").list();
        transaction.commit();
        session.close();

        request.setAttribute("countries", countries);
        request.setAttribute("types", types);
        request.setAttribute("manufactorers", manufacturers);
        getServletContext().getRequestDispatcher("/manufactorer.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedType = request.getParameter("selectedType");
        if(selectedType!=null){
            WatchType type = null;
            if(selectedType.equals("Quartz")) type = WatchType.Quartz;
            if(selectedType.equals("Mechanical")) type = WatchType.Mechanical;

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            manufacturers = session
                    .createQuery("select m FROM Manufacturer m inner join m.watches w where w.type = :type group by m order by m.id", Manufacturer.class)
                    .setParameter("type", type)
                    .list();
            transaction.commit();
            session.close();
        }

        String selectedCountry = request.getParameter("selectedCountry");
        if(selectedCountry!=null){

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            manufacturers = session
                    .createQuery("FROM Manufacturer m  where m.country = :country order by m.id", Manufacturer.class)
                    .setParameter("country", selectedCountry)
                    .list();
            transaction.commit();
            session.close();
        }


        request.setAttribute("countries", countries);
        request.setAttribute("types", types);
        request.setAttribute("manufactorers", manufacturers);
        getServletContext().getRequestDispatcher("/manufactorer.jsp").forward(request, response);

    }

    @Override
    public void init() throws ServletException {
        super.init();

        types = new ArrayList<>();
        types.add(WatchType.Quartz.name());
        types.add(WatchType.Mechanical.name());


        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        manufacturers = session.createQuery("FROM Manufacturer order by id", Manufacturer.class).list();
        countries = session.createQuery("select m.country from Manufacturer m group by m.country").list();
        transaction.commit();
        session.close();
    }

}
