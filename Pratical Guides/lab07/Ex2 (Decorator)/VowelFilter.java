package Ex2;
public class VowelFilter extends TFDecorator{
    VowelFilter(Reader r) {
        super(r);
    }
    @Override
    public boolean hasNext(){
        return super.hasNext();
    }
    @Override
    public String next() {
        String str = super.next();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if ( str.charAt(i) == ' ' || "AEIOUaeiou".indexOf(str.charAt(i))==-1) {
                result += str.charAt(i);
            }
        }
        return result;
    }
}