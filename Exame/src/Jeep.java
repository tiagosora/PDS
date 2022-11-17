
public class Jeep implements Product{
    private String code;
    private String description;
    private double points;

    public Jeep(OldJeep oj) {
        String[] splitedData = oj.getData().split(";");
        this.code = splitedData[0];
        this.description = splitedData[1];
        this.points = Double.parseDouble(splitedData[2]);
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public double points() {
        return this.points;
    }

    @Override 
	public String toString(){
		return "Jeep [code="+this.code+", descr="+this.description+", points="+this.points+"]";
	}

}
