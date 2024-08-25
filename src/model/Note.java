package model;

public class Note {
    private String date;
    private String time;
    private String content;

    public Note(String date, String time, String content) {
        this.date = date;
        this.time = time;
        this.content = content;
    }

    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getContent() { return content; }

    @Override
    public String toString() {
        return date + " " + time + ": " + content;
    }
}