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

@WebServlet(name = "WatchesFormServlet", value = "/editW")
public class WatchesFormServlet  extends HttpServlet {

    private Long id;
    private Manufacturer m;

    private Watch w;
    private String idParam;

    private List<String> types;

    private List<Manufacturer> manufacturers;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idParam = request.getParameter("id");
        if (idParam != null) {
            id = Long.parseLong(idParam);

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
                w = session.get(Watch.class, id);
                manufacturers = session.createQuery("FROM Manufacturer order by id", Manufacturer.class).list();
            transaction.commit();
            session.close();


            request.setAttribute("brand", w.getBrand());
            request.setAttribute("price", w.getPrice());
            request.setAttribute("quantity", w.getQuantity());
            request.setAttribute("brand", w.getBrand());
            request.setAttribute("selectedType", w.getType());
            request.setAttribute("selectedManufactorer", w.getManufacturer().getId());


        } else {
            request.setAttribute("title", "Добавление");
        }

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        manufacturers = session.createQuery("FROM Manufacturer order by id", Manufacturer.class).list();
        transaction.commit();
        session.close();

        request.setAttribute("types", types);
        request.setAttribute("manufactorers", manufacturers);

        request.getRequestDispatcher("/WForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(idParam!=null){

            w.setBrand(request.getParameter("brand"));
            w.setPrice(Double.parseDouble(request.getParameter("price")));
            w.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            if(request.getParameter("selectedType").equals(WatchType.Quartz.name())){
                w.setType(WatchType.Quartz);
            }
            if(request.getParameter("selectedType").equals(WatchType.Mechanical.name())){
                w.setType(WatchType.Mechanical);
            }
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
                Manufacturer m  = session.get(Manufacturer.class, Long.parseLong(request.getParameter("selectedManufactorer")));
            transaction.commit();
            session.close();
            w.setManufacturer(m);

            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(w);
            transaction.commit();
            session.close();
        } else {

            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Manufacturer m  = session.get(Manufacturer.class, Long.parseLong(request.getParameter("selectedManufactorer")));
            transaction.commit();
            session.close();

            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
                session.save(
                        new Watch(
                                request.getParameter("brand"),
                                request.getParameter("selectedType").equals(WatchType.Mechanical.name())? WatchType.Mechanical : WatchType.Quartz,
                                Double.parseDouble(request.getParameter("price")),
                                Integer.parseInt(request.getParameter("quantity")),
                                m
                        )
                );
            transaction.commit();
            session.close();
        }
        response.sendRedirect("/example");

    }

    @Override
    public void init() throws ServletException {
        super.init();

        types = new ArrayList<>();
        types.add(WatchType.Quartz.name());
        types.add(WatchType.Mechanical.name());

    }
}
