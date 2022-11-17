package Ex2;
public abstract class TFDecorator implements Reader {
    protected Reader r;
    TFDecorator(Reader r){
        this.r = r;
    }
    public boolean hasNext() {
        return this.r.hasNext();
    }
    public String next() {
        return this.r.next();
    }
}