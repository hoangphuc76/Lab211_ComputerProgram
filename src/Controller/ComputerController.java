package Controller;

import Model.BMICalculator;
import Model.NormalCalculator;
import View.ComputerView;
import View.Menu;

public class ComputerController extends Menu {
    ComputerView cv = new ComputerView();
    NormalCalculator nc;
    BMICalculator bc;

    public ComputerController() {
        super("========= Calculator Program =========", new String[] {
                "Normal Calculator", "BMI Calculator", "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                nc = new NormalCalculator();
                cv.doNormalCalculator(nc);
                break;
            case 2:
                cv.doCalculateBMI(bc);
                break;

        }
    }
}
