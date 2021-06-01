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

@WebServlet(name = "CardsServlet", value = "/Cards")
public class CardsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardsDao cardsDao = DaoFactory.getCardsDao();
        List<Cards> cards = cardsDao.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cards);

        objectMapper.writeValue(response.getWriter(), json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CardsDao cardsDao = DaoFactory.getCardsDao();
        String accountNumber = request.getParameter("accountNumber");
        Cards cards = cardsDao.create(accountNumber);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cards);

        objectMapper.writeValue(response.getWriter(), json);
        }
    }



