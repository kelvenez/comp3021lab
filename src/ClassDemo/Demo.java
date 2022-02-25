package ClassDemo;

class X{
    static boolean s = false;
    static{
        if(s)
                System.out.println("c");
    }
    {
        if(s)
            System.out.println(("d"));
    }

    public void m(){
        System.out.println(("a"));
        s = false;
    }

    public X(){
        m();
        if(s)
            System.out.println("e");
    }
}

class Y extends X{
    public void m(){
        System.out.println("b");
        System.out.println("here");
        s = true;
    }

    public Y(){
        m();
    }
}

public class Demo{
    public static void main(String[] args){
        X a = new Y();
    }
}

