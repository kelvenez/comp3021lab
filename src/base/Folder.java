package base;
import java.util.*;

public class Folder {
    private ArrayList<Note> notes;
    private String name;

    public Folder(String name) {
        this.name = name;
        this.notes = new ArrayList<Note>();
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
      //  if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       // Folder folder = (Folder) o;
        return name.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        int nText = 0;
        int nImage = 0;
        for (Note note : notes)
            if (note instanceof TextNote)
                nText++;
            else if (note instanceof ImageNote)
                nImage++;
        return name + ":" + nText + ":" + nImage;
    }
}