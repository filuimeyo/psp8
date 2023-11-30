package com.example.Part1Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "Part1Servlet", value = "/font")
public class Part1Servlet extends HttpServlet {

    private String text;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            text = Files.readString(Paths.get("D:\\strweb\\psp8\\src\\main\\resources\\text.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("text", text);
        request.setAttribute("fontSize", 14);
        request.setAttribute("number", 5);
        request.getRequestDispatcher("/part1.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int f = Integer.parseInt(request.getParameter("fontSize"));
        int n = Integer.parseInt(request.getParameter("number"));
        request.setAttribute("fontSize", f);
        request.setAttribute("number", n);
        request.setAttribute("text", text);
        request.getRequestDispatcher("/part1.jsp").forward(request, response);
    }
}