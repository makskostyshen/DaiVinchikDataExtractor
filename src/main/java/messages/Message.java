package messages;

import mainClasses.PATH_CONSTANTS;

import java.util.List;

public class Message {

    private Integer ID = 0;
    private String date = "";
    private String from = "";
    private String photoPath = "";
    private String text = "";


    public Message(){}

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = PATH_CONSTANTS.getFullPathFromPartial(photoPath);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "id: " + ID + "\n" +
                "date: " + date + "\n" +
                "from: " + from + "\n" +
                "photo: " + photoPath +"\n" +
                "text: " + text;
    }
}