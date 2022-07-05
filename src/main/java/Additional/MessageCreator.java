package Additional;

import Commands.*;
import arguments.Argument;
import arguments.IntArgument;
import arguments.StringArgument;
import com.google.gson.stream.JsonToken;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageCreator {

    ///awesome
    public List<Message> read() throws IOException {

        OwnJsonReader reader = new OwnJsonReader(PATH_CONSTANTS.getJsonFilePath());
        List<Message> messages = new ArrayList<>();

        while (reader.hasNext()){
            Message newMessage = getNewMessage(reader);
            messages.add(newMessage);
        }
        reader.close();
        return messages;
    }


    private Message getNewMessage(OwnJsonReader reader) throws IOException {
        reader.beginObject();

        Message newMessage = new Message();

        while(reader.hasNext()){

            String fieldName = reader.nextName();
            JsonToken fieldType = reader.peek();

            Argument newArgument = getNewArgument(fieldName, fieldType, reader);

            if (newArgument == null){
                continue;
            }

            Command newCommand = getNewCommand(fieldName, fieldType, reader);
            newCommand.set(newMessage, newArgument);
        }

        reader.endObject();
        return newMessage;
    }


    private Argument getNewArgument(String fieldName, JsonToken fieldType, OwnJsonReader reader) throws IOException {
        switch (fieldName){
            case ("id"):
                return new IntArgument(reader.nextInt());
            case ("date"):
            case ("from"):
            case ("photo"):
                return new StringArgument(reader.nextString());
            case ("text"):
                return getTextArguments(fieldType, reader);
            default:
                reader.skipValue();
                return null;
            }
        }

        private Argument getTextArguments(JsonToken fieldType, OwnJsonReader reader) throws IOException {

//            while(reader.hasNext()){
//                reader.nextName();
//                reader.skipValue();
//            }
///////test inherited textttssssss
            reader.skipValue();
            return new StringArgument("fv");
        }


        private Command getNewCommand(String fieldName, JsonToken fieldType, OwnJsonReader reader) throws IOException {
            switch (fieldName){
                case ("id"):
                    return new setID();
                case ("date"):
                    return new setDate();
                case ("from"):
                    return new setFrom();
                case ("photo"):
                    return new setPhotoPath();
                case ("text"):
                    return new setText();
                default:
                    return null;
            }
        }

}
