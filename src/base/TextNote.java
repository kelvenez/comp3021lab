package base;

import org.w3c.dom.Text;

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

}
