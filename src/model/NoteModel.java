package model;

import java.util.List;

public interface NoteModel {
    void addNote(String date, String time, String content);
    List<Note> getNotes(String date);
    List<Note> searchNotes(String keyword);
    List<Note> getNotesForWeek(String startDate);
    void setFilename(String filename);
}
