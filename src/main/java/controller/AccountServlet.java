package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountDao;
import dao.CardsDao;
import dao.DaoFactory;
import model.Account;
import model.Cards;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/Account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDao accountDao = DaoFactory.getAccountDao();
        Account account = AccountDao.get(a);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(account);

        objectMapper.writeValue(response.getWriter(), json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
