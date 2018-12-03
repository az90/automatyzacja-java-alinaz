import java.util.Scanner;

public class FirstClass {
    public static void main(String[] args){
        System.out.println("Witaj świecie!");
        String exit = "";
        String equal = "exit";

        while(!exit.equals(equal)){
            System.out.println("Aby zamknąć aplikację wpisz 'exit' i naciśnij enter");
            Scanner read = new Scanner(System.in);
            exit = read.nextLine();
        }

    }
}
