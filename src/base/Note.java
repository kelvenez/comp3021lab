package base;

import java.util.Date;
import java.util.Objects;


public class Note {

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

}
