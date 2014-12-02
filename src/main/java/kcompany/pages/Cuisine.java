package kcompany.pages;

/**
 * Created by User on 02.12.2014.
 */
public class Cuisine {
    String name;


    @Override
    public boolean equals(Object anObject){
        if (!(anObject instanceof Cuisine)){
            return false;
        }
        final Cuisine c = (Cuisine) anObject;
        if ((this.name == null) ? (c.name != null) : !this.name.equals(c.name)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b= new Cuisine().equals(null);
        System.out.println(b);
    }
}
