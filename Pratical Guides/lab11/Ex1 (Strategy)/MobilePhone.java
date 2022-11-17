package Ex1;

public class MobilePhone {
    private String model;
    private String processor;
    private String price;
    private String memory;
    private String camera;

    public MobilePhone(String model, String processor, String price, String memory, String camera) {
        this.model = model;
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    public String getModel() {
        return model;
    }
    public String getProcessor() {
        return processor;
    }
    public String getPrice() {
        return price;
    }
    public String getMemory() {
        return memory;
    }
    public String getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return model + " specs: Processor " + processor + "; Price " + price + "; Memory " + memory + "; Camera " + camera;
    }
}
