package Additional;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OwnJsonReader{

    private JsonReader innerReader;

    public OwnJsonReader(String jsonFilePath) throws IOException {
        innerReader = new JsonReader(new BufferedReader(new FileReader(jsonFilePath)));
        makeInitialActions();
    }

    private void makeInitialActions() throws IOException {
        System.out.println(innerReader.peek());
        innerReader.beginObject();

        innerReader.nextName();
        innerReader.nextString();

        innerReader.nextName();
        innerReader.nextString();

        innerReader.nextName();
        innerReader.nextInt();

        innerReader.nextName();
        innerReader.beginArray();
    }

    public void close() throws IOException {
        System.out.println("attention: " + innerReader.peek());
        innerReader.endArray();
        innerReader.endObject();
        innerReader.close();
    }

    public boolean hasNext() throws IOException {
        return innerReader.hasNext();
    }

    public void beginArray() throws IOException {
        innerReader.beginArray();
    }

    public void endArray() throws IOException {
        innerReader.endArray();
    }

    public void beginObject() throws IOException {
        innerReader.beginObject();
    }

    public void endObject() throws IOException {
        innerReader.endObject();
    }

    public void skipValue() throws IOException {
        innerReader.skipValue();
    }

    public String nextString() throws IOException{
        return innerReader.nextString();
    }

    public int nextInt() throws IOException{
        return innerReader.nextInt();
    }

    public JsonToken peek() throws IOException {
        return innerReader.peek();
    }

    public String nextName() throws IOException {
        return innerReader.nextName();
    }
}
