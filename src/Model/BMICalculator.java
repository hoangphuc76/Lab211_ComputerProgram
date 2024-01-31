package Model;

public class BMICalculator {
    private double weight, height;
    private double BmiNumber;
    public BMICalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public void setBmiNumber() {
        BmiNumber = weight / (Math.pow(height,2));
    }

    public double getBmiNumber() {
        return BmiNumber;
    }
}
