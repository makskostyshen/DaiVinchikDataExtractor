package Additional;

import Additional.PATH_CONSTANTS;
import Additional.OwnJsonReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try{
            System.out.println(PATH_CONSTANTS.getJsonFilePath());
            OwnJsonReader reader = new OwnJsonReader(PATH_CONSTANTS.getJsonFilePath());

            reader.beginObject();
            System.out.println(reader.nextName());
            System.out.println(reader.peek());

            reader.beginArray();
            reader.skipValue();

            System.out.println(reader.peek());
            reader.endArray();
            reader.endObject();
            System.out.println("===========");

            reader.beginObject();
            System.out.println(reader.nextName());
            System.out.println(reader.peek());

            reader.beginArray();
            System.out.println(reader.peek());
/*            MessageCreator creator = new MessageCreator();
            List<Message> messages = creator.read();
            printMessages(messages);*/
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
