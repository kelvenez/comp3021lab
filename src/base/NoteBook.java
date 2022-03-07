package base;
import java.util.*;

public class NoteBook {
    private ArrayList<Folder> folders;

    public NoteBook(){
        this.folders = new ArrayList<Folder>();
    }

    public boolean createTextNote(String folderName , String title ){
            TextNote note = new TextNote(title);
            return insertNote(folderName,note);
    }
    //Overloading method createTextNote
    public boolean createTextNote(String folderName, String title, String content){
        TextNote note = new TextNote(title,content);
        return insertNote(folderName,note);
    }


    public boolean createImageNote(String folderName , String title){
            ImageNote note = new ImageNote(title);
            return insertNote(folderName,note);
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public boolean insertNote(String folderName , Note note) {
        Folder tempFolder = null;
        for (Folder folder : folders) {
            if (folder.getName().equals(folderName)) { // pass string
                tempFolder = folder;
                break;
            }
        }
        if (tempFolder == null) {
            tempFolder = new Folder(folderName);
            this.folders.add(tempFolder);
        }

        for (Note n : tempFolder.getNotes()) {
            if (n.equals(note)) {
                    System.out.println("Creating note " + note.getTitle() + " under folder " + folderName + " failed");
                return false;
            }
        }
        tempFolder.addNote(note);
        return true;
    }

    public void sortFolders(){
        for (Folder folder : folders)
            folder.sortNotes();
        folders.sort(null);
    }
     // "java or LAB attendance OR SESSION"
    public List<Note> searchNotes(String keywords){
        List<List<Note>> result = new ArrayList<List<Note>>();
        for(Folder folder : folders)
            result.add(folder.searchNotes(keywords));
        List<Note> result_note = new ArrayList<Note>();
        for(List<Note> ls : result){
            for(Note n : ls ){
                result_note.add(n);
            }
        }
        return result_note;
    }

}
