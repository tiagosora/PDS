package Ex3;

public abstract class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void technicalSupport();
}
