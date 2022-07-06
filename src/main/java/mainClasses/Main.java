package mainClasses;

import messages.Message;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try{
            Processor p = new Processor();
            List<Message> messages = p.process();
            printMessages(messages);
        }
        catch (Exception e){
            System.out.println("ERROR");
            System.out.println(e.getLocalizedMessage());
        }
    }


    private static void printMessages(List<Message> messages){
        for (Message message: messages){
            System.out.println(message);
            System.out.println("\n");
        }
    }
}
