package Ex2;
import java.text.Normalizer;
import java.text.Normalizer.Form;
public class NormalizationFilter extends TFDecorator{
    NormalizationFilter(Reader r) {
        super(r);
    }
    @Override
    public boolean hasNext(){
        return super.hasNext();
    }
    @Override
    public String next() {
        return Normalizer.normalize(super.next(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}