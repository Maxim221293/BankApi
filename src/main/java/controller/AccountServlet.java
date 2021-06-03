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


@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        AccountDao accountDao = DaoFactory.getAccountDao();
        Account account = accountDao.get(accountNumber);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), account);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDao accountDao = DaoFactory.getAccountDao();
        String accountNumber = request.getParameter("accountNumber");
        String sum = request.getParameter("sum");

        Account account = accountDao.deposit(accountNumber, Long.parseLong(sum));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), account);


    }
}
