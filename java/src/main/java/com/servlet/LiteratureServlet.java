package com.servlet;

import com.google.gson.Gson;
import com.model.Literature;
import com.service.LiteratureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/literature")
public class LiteratureServlet extends HttpServlet {
    private LiteratureService literatureService = new LiteratureService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Literature> literatureList = literatureService.getAllLiteratureList();
        System.out.println("Книги у відповіді: " + literatureList.size()); // Логування
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(literatureList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Literature newLiterature = gson.fromJson(reader, Literature.class);
        literatureService.addLiterature(newLiterature);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Literature updatedLiterature = gson.fromJson(reader, Literature.class);
        if (literatureService.updatedLiterature(updatedLiterature)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (literatureService.deleteLiterature(id)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
