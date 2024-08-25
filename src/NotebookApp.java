import model.NoteModel;
import model.NoteModelImpl;
import view.NoteView;
import view.ConsoleNoteView;
import presenter.NotePresenter;

public class NotebookApp {
    public static void main(String[] args) {
        NoteModel model = new NoteModelImpl();
        NoteView view = new ConsoleNoteView();
        NotePresenter presenter = new NotePresenter(model, view);

        String filename = "notes.csv";
        model.setFilename(filename);
        view.showMessage("Заметки будут автоматически сохраняться в файл: " + filename);

        while (true) {
            String choice = view.getInput(
                    "\nВыберите действие:\n" +
                            "1. Добавить заметку\n" +
                            "2. Показать заметки на дату\n" +
                            "3. Поиск заметок\n" +
                            "4. Показать заметки на неделю\n" +
                            "5. Выход\n" +
                            "Ваш выбор: "
            );

            switch (choice) {
                case "1":
                    presenter.addNote();
                    break;
                case "2":
                    presenter.showNotes();
                    break;
                case "3":
                    presenter.searchNotes();
                    break;
                case "4":
                    presenter.showWeekNotes();
                    break;
                case "5":
                    view.showMessage("Программа завершена");
                    return;
                default:
                    view.showMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}