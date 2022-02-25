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

    public boolean createImageNote(String folderName , String title){
            ImageNote note = new ImageNote((title));
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

}
