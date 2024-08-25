package view;

import model.Note;
import java.util.List;

public interface NoteView {
    void showMessage(String message);
    void showNotes(List<Note> notes);
    String getInput(String prompt);
}