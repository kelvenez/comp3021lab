package base;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class Folder implements Comparable<Folder>, Serializable {
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

    public void sortNotes(){
        Collections.sort(notes);
    }
    //"java or LAB attendance OR SESSION"
    public List<Note> searchNotes(String keywords){
        keywords = keywords.replaceAll(" (?i)or ","#");
        keywords = keywords.replaceAll(" ","&");
        keywords = keywords.replaceAll("#"," ");
        List<String> key = new ArrayList<String>();
        List<Note> result = new ArrayList<Note>();
        for(String keyword : keywords.split("&"))
            key.add(keyword);
        for(Note n : notes) {
            boolean add = false;
            for (String s : key) {
                boolean contain = false;
                for (String t : s.split(" ")) {
                    if (n instanceof ImageNote) //
                        if ( ((ImageNote)n).getTitle().matches(".*(?i)"+t+".*"))
                            contain = true;
                        else continue;
                    else if (n instanceof TextNote)
                        if ( ((TextNote)n).getTitle().matches(".*(?i)"+t+".*")|| ((TextNote)n).getContent().matches(".*(?i)"+t+".*"))
                            contain = true;
                        else continue;
                }
            if(contain == true)
                add =true;
            else
                add =false;
            }
        if(add == true)
            result.add(n);
        }
        return result;
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

    @Override
    public int compareTo(Folder o){
        return name.compareTo(o.getName());
    }


}