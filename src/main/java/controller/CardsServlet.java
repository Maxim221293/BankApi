package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CardsDao;
import dao.DaoFactory;
import model.Cards;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "CardsServlet", value = "/cards")
public class CardsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardsDao cardsDao = DaoFactory.getCardsDao();
        List<Cards> cards = cardsDao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), cards);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardsDao cardsDao = DaoFactory.getCardsDao();
        String cardsNumber = request.getParameter("cardsNumber");
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        Cards cards = cardsDao.create(cardsNumber, accountId);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), cards);
    }
}



