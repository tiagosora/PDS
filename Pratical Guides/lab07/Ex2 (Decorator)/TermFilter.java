package Ex2;
public class TermFilter extends TFDecorator{
    private int nWords = -1;
    TermFilter(Reader r) {
        super(r);
    }
    @Override
    public boolean hasNext(){
        if (this.nWords == super.next().split("\\s").length - 1) {
            return false; 
        } 
        return true;
    }
    @Override
    public String next(){
        String words[] = super.next().split("\\s");
        this.nWords++;
        return words[this.nWords];
    }
}