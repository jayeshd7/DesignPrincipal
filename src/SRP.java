import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SRP {

    public static void main(String args[]) throws IOException {

        Journal journal = new Journal();
        journal.addentry("i am jayesh");
        journal.addentry("i am jayesh");
        journal.addentry("i ate a bug");
        System.out.println(journal);




        Persistance persistance = new Persistance();
        persistance.saveToFile(journal,"abc.txt",true);

        //Runtime.getRuntime().exec("");
    }


}

class Journal {

    private final List<String> entries = new ArrayList<String>();
    private static int count = 0;


    public void addentry(String text) {

        entries.add("" + (++count) + ":" + text);

    }

    public void removeEntry(int index) {

        entries.remove(index);
    }


    @Override
    public String toString() {

        return String.join(System.lineSeparator(), entries);
    }


    public void save(String fileName) {
        try (PrintStream out = new PrintStream(fileName)) {
            out.println(toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void load (String fileName){}
    public void URL (URL url) {}

}


class Persistance
{




    public void saveToFile(Journal journal,
                           String fileName,
                           Boolean overwrite) throws FileNotFoundException
{
    if(overwrite  || new File(fileName).exists()) {
        try (PrintStream out = new PrintStream(fileName)) {
            out.println(toString());
        }
    }
}
    /*public  Journal load(String fileName){ return journal;}
    public Journal load(URL url){}*/


}
