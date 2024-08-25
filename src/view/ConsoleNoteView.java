package view;

import model.Note;
import java.util.List;
import java.util.Scanner;

public class ConsoleNoteView implements NoteView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Записей нет");
        } else {
            notes.forEach(System.out::println);
        }
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
