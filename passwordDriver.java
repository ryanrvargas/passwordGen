import java.util.InputMismatchException;
import java.util.Scanner;
public class passwordDriver {
    public static void main(String[] args) {
        passwordGenerator p = new passwordGenerator(12);
        p.generateP();
        p.generateP();
        p.generateP();
        p.generateP();

        p.getSavedP();
    }
}
