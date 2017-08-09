package com.realdolmen.candyshop.servlets;

import com.realdolmen.candyshop.services.PersonService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/people")
public class PeopleServlet extends HttpServlet {
    @Inject
    PersonService personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", personService.findAllPeople());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/people.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
