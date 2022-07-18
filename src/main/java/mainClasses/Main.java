package mainClasses;

import messages.Message;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connector connector = new Connector();
        try{
            MessagesGetter getter = new MessagesGetter();
            List<Message> messages = getter.getMessages();

//            printMessages(messages);

            connector.connect();
            System.out.println(connector.getConnection().getClientInfo("characterEncoding"));
            connector.loadMessages(messages);
//

//            System.out.println(connector.getConnection().getClientInfo("characterEncoding"));

        }
        catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getLocalizedMessage());
        }
        finally{
            connector.close();
        }
    }


    private static void printMessages(List<Message> messages){
        for (Message message: messages){
            System.out.println(message);
            System.out.println("\n");
        }
    }

}
