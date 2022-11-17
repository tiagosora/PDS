package Ex2;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        File f = new File("Ex2/textfile.txt");
        Reader r1 = new TextReader(f);
        Reader r2 = new CapitalizationFilter(new TextReader(f));
        Reader r3 = new NormalizationFilter(new TermFilter(new TextReader(f)));
        Reader r4 = new VowelFilter(new NormalizationFilter(new TextReader(f)));
        Reader r5 = new VowelFilter(new TermFilter(new TextReader(f)));
        Reader r6 = new CapitalizationFilter(new TermFilter(new TextReader(f)));
        Reader r7 = new NormalizationFilter(new VowelFilter(new CapitalizationFilter(new TermFilter(new TextReader(f)))));
        Reader readerList[] = {r1,r2,r3,r4,r5,r6,r7};
        for (Reader reader : readerList) {
            System.out.println(reader.next());
            System.out.println(reader.next()+"\n");
        }
    }
}