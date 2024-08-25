package model;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class NoteModelImpl implements NoteModel {
    private List<Note> notes = new ArrayList<>();
    private String filename;

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
        loadFromFile();
    }

    @Override
    public void addNote(String date, String time, String content) {
        notes.add(new Note(date, time, content));
        saveToFile();
    }

    @Override
    public List<Note> getNotes(String date) {
        return notes.stream()
                .filter(note -> note.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> searchNotes(String keyword) {
        return notes.stream()
                .filter(note -> note.getContent().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getNotesForWeek(String startDate) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = start.plusDays(7);
            return notes.stream()
                    .filter(note -> {
                        LocalDate noteDate = LocalDate.parse(note.getDate());
                        return (noteDate.isEqual(start) || noteDate.isAfter(start)) &&
                                (noteDate.isBefore(end) || noteDate.isEqual(end));
                    })
                    .collect(Collectors.toList());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Date,Time,Content");
            for (Note note : notes) {
                writer.println(note.getDate() + "," + note.getTime() + "," + escapeSpecialCharacters(note.getContent()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file", e);
        }
    }

    private void loadFromFile() {
        notes.clear();
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                reader.readLine(); // Skip header
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",", 3);
                    if (parts.length == 3) {
                        notes.add(new Note(parts[0], parts[1], unescapeSpecialCharacters(parts[2])));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Error loading from file", e);
            }
        }
    }

    private String escapeSpecialCharacters(String content) {
        return content.replace(",", "\\,").replace("\n", "\\n");
    }

    private String unescapeSpecialCharacters(String content) {
        return content.replace("\\,", ",").replace("\\n", "\n");
    }
}