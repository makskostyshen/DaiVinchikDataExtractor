package messages;

import mainClasses.FilePathConstants;

public class Message {

    private Integer id = 0;
    private String date = "";
    private String sender = "";
    private String photoPath = "";
    private String text = "";


    public Message(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = FilePathConstants.getFullPathFromPartial(photoPath);
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "date: " + date + "\n" +
                "from: " + sender + "\n" +
                "photo: " + photoPath +"\n" +
                "text: " + text;
    }
}