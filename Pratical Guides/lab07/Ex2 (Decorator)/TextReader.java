package Ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TextReader implements Reader {
    private File txtfile;
    private Scanner sc;
    public TextReader(File txtfile){
        this.txtfile = txtfile;
        try {
            this.sc = new Scanner(this.txtfile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR - File not found");
        }
    }
    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }
    @Override
    public String next() {
        return sc.nextLine();
    }
}