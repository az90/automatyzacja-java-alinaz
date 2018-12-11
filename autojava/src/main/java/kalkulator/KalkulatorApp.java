package kalkulator;

public class KalkulatorApp {

    public int add(int a, int b){
        //nie mamy static wiec metoda wymaga tworzenia obiektu klasy KalkulatorApp(nie da się KalkulatorApp.add())
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public double devide(double a, double b){
        return a / b;
    }

}
