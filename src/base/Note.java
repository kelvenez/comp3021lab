package base;

import java.util.Date;


public class Note implements Comparable<Note> {

    private Date date;
    private String title;

    public Note(String title){
        this.title = title;
        this.date = new Date(System.currentTimeMillis());
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null ) return false;
        Note note = (Note) o;
        return note.getTitle().equals(title);
    }

    @Override
    public int compareTo(Note o){
            return o.date.compareTo(this.date); // >date:1  =date:0 <date:-1
    }

    public String toString(){
        return date.toString() + "\t" + title;
    }
}
