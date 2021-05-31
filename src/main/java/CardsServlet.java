import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class CardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter print = response.getWriter();
            Class.forName ("org.h2.Driver");
            //инф. о базе данных
            Connection conn = DriverManager.getConnection("jdbc:h2://localhost:8080/cards",
                    "Maxim", "");
           // создаем объект для создания запросов
            Statement stmt = conn.createStatement();
            ResultSet cards = stmt.executeQuery("SELECT * FROM cards");
            while (cards.next()) {
                print.println(cards.getString("cards_id"));
                print.println(cards.getString("account_number"));

                stmt.close();
                conn.close();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
