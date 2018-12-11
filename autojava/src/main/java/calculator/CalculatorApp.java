package calculator;

public class CalculatorApp {

    public int add(int a, int b){
        //nie mamy static wiec metoda wymaga tworzenia obiektu klasy CalculatorApp(nie da się CalculatorApp.add())
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public double devide(double a, double b){
        return a / b;
    }

}
