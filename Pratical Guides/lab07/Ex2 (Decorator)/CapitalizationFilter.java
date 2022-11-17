package Ex2;
public class CapitalizationFilter extends TFDecorator{
    CapitalizationFilter(Reader r) {
        super(r);
    }
    @Override
    public boolean hasNext(){
        return super.hasNext();
    }
    @Override
    public String next() {
        char c[] = super.next().toCharArray();
        for(int i = 0; i < c.length; i++){
            if(i == 0 || i == c.length-1){
                c[i] = Character.toUpperCase(c[i]);
            } else {
                c[i] = Character.toLowerCase(c[i]);
            }
        }
        String result = "";
        for (char ch : c) {
            result += ch;   
        }
        return result;
    }
}