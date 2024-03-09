import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class TitleBase {
    //public static void main(String[] args) {
    //    System.out.println("hi there!");
    //}
    private Path filePath;
    public Encoding encoding;
    private Scanner scanner = null;


    /*
        constructors, used to properly handle file objects with their attributes
     */
    public TitleBase(String filePath, Encoding encoding){
        this.filePath = Paths.get(filePath);
        this.encoding = encoding;
    }
    public TitleBase(String filePath){
        this(filePath, Encoding.plaintext);
    }

    public String readFileAsString() throws Exception{
        return new String(Files.readAllBytes(this.filePath));
    }

    /*
    use with an iterator .i.e:
    Iterator<String> itr = l.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
     */
    public List<String> readFileToList(){
        List<String> ret = Collections.emptyList();
        try{
            ret = Files.readAllLines(this.filePath, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    public String readLineByLine() throws Exception{
        if(this.scanner == null)
            this.scanner = new Scanner(this.filePath);

        if(this.scanner.hasNextLine())
            return this.scanner.nextLine();
        else
            return null;
    }

    public String pickRandomTitle(){
        List t = this.readFileToList();
        int r = new Random().nextInt(0, t.size()-1);
        return t.get(r).toString();
    }

}
