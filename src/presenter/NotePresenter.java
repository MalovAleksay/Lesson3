package presenter;

import model.NoteModel;
import model.Note;
import view.NoteView;

import java.util.List;

public class NotePresenter {
    private NoteModel model;
    private NoteView view;

    public NotePresenter(NoteModel model, NoteView view) {
        this.model = model;
        this.view = view;
    }

    public void addNote() {
        String date = view.getInput("Введите дату (yyyy-MM-dd): ");
        String time = view.getInput("Введите время (HH:mm): ");
        String content = view.getInput("Введите содержание заметки: ");
        model.addNote(date, time, content);
        view.showMessage("Заметка добавлена и сохранена");
    }

    public void showNotes() {
        String date = view.getInput("Введите дату для просмотра заметок (yyyy-MM-dd): ");
        List<Note> notes = model.getNotes(date);
        view.showNotes(notes);
    }

    public void searchNotes() {
        String keyword = view.getInput("Введите ключевое слово для поиска: ");
        List<Note> results = model.searchNotes(keyword);
        view.showNotes(results);
    }

    public void showWeekNotes() {
        String startDate = view.getInput("Введите начальную дату недели (yyyy-MM-dd): ");
        List<Note> weekNotes = model.getNotesForWeek(startDate);
        view.showNotes(weekNotes);
    }
}