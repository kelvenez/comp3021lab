package base;

import java.io.*;


public class TextNote extends Note{
    private String content;

    public TextNote(String title){
        super(title);
    }
    public TextNote(String title, String content){
        super(title);
        this.content = content;
    }
    public String getContent(){return this.content;}

    public void setContent(String content) {
        this.content = content;
    }

    /* load a TextNote from File f
           the tile of the TextNote is the name of the file
           the content of the TextNote is the content of the file
           @param File f
         */
    public TextNote(File f){
        super(f.getName());
        this.content = getTextFromFile(f.getAbsolutePath());
    }

    /*
    get the content of a file
    @param absolutePath of the file
    @return the content of the file
     */
    private String getTextFromFile(String absolutePath){
        String result = "";
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(absolutePath);
            in = new ObjectInputStream(fis);
            result = (String) in.readObject();
            in.close();
        } catch (Exception e){
            System.out.println("Fail load the TextFile");
        }
        return result;
    }

    /* export text note to file
    @param pathFolder path of the folder where to export the note
    the file has to be named as the title of the note with extension ".txt"
    if the tile contains white spaces " " they have to be replaced with underscores"_"
     */
    public void exportTextToFile(String pathFolder){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        pathFolder = System.getProperty("user.dir");
        File file = new File(pathFolder + File.separator + this.getTitle().replaceAll(" ","_") + ".txt");
        try{
            fos = new FileOutputStream(file.getAbsolutePath());
            out = new ObjectOutputStream(fos);
            out.writeObject(this);
            out.close();
            fos.close();
        }catch(Exception e) {
            System.out.println(e);
            System.out.println("Fail export Text To File");
        }
    }
}
