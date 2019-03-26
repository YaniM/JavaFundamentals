package carsalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String colour;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.colour = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String colour) {
        this(model, engine);
        this.colour = colour;
    }

    public Car(String model, Engine engine, int weight, String colour) {
        this(model, engine, weight);
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        String newWeight = this.getWeight() == -1 ? "n/a" : String.valueOf(this.getWeight());
        String newDisplacement = this.getEngine().getDisplacement() == -1 ? "n/a" : String.valueOf(this.getEngine().getDisplacement());
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s",
                this.getModel(),
                this.engine.getModel(),
                this.engine.getPower(),
                newDisplacement,
                this.engine.getEfficiency(),
                newWeight,
                this.getColour());
    }
}

