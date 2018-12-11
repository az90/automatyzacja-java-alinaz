package kalkulator;

import static org.junit.jupiter.api.Assertions.*; //nie musie miec  Assertions przed .assertEquals

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testy kalkulatora") //<-nie jest to dobre, ciężko potem zobaczyć co metoda robi
public class KalkulatorAppTest {

    //arrange
    KalkulatorApp kalkulatorek = new KalkulatorApp();

    @Test
    public void addTwoPositiveIntigerTest() {

        //act
        int suma = kalkulatorek.add(4, 5);
        //assert
        assertEquals(9, suma, "Sprawdz, ze dodawanie liczb całkowitych działa");
        //assertEquals - metoda statyczna - nie wymaga istnienia obiektu klasy Assertions
    }

    @Test
    void addTwoPositiveDoubleTest() {

        //act
        double sumaDouble = kalkulatorek.add(1.2, 2.4);
        //assert - test z dokladnoscia do 7 miejsca po przecinku - sprawdzenie dwoch wartosci z delta
        assertEquals(3.6, sumaDouble, 0.0000001, "Sprawdz, że dodawanie liczb zmiennoprzecinkowych działa");
    }

    @Test
    void  devideTwoPositiweDoubleTest() {

        //act
        double quotient = kalkulatorek.devide(2,3);
        //assert
        assertEquals(0.666667 ,quotient,0.000001, "Sprawdz, ze dzielenie liczb zmiennoprzecnikowych dziala");
    }
}