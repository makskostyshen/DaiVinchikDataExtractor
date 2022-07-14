package mainClasses;
import messages.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try{
            MessagesGetter getter = new MessagesGetter();
            List<Message> messages = getter.getMessages();
            printMessages(messages);

            Connection connection = getConnection();
        }
        catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getLocalizedMessage());
        }
    }

    static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/maks_kostyshen?autoReconnect=true&useSSL=false",
                "root",
                "okcsonic");
    }

    private static void printMessages(List<Message> messages){
        for (Message message: messages){
            System.out.println(message);
            System.out.println("\n");
        }
    }
}
