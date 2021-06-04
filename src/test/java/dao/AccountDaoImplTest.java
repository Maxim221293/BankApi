//package dao;
//
//import junit.framework.TestCase;
//import model.Account;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class AccountDaoImplTest extends TestCase {
//    String url = "jdbc:h2:/Users/u19215097/BankApi/dataBase/bd";
//    String user = "Maxim";
//    String password = "";
//    private static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("org.h2.Driver");
//        return DriverManager.getConnection(url, user, password);
//    }
//}
//   AccountDao accountDao = new AccountDao() {
//       @Override
//       public Account deposit(String accountNumber, long sum) {
//           return null;
//       }
//
//       @Override
//       public Account get(String accountNumber) {
//           return null;
//       }
//
//
//    public void testDeposit() {
//
//    }
//
//    public void testGet() {
//    }
//}