package calculator;

import static org.junit.Assert.fail;

public class Calculator {
    
    public boolean isActive = true;
    public String[] methods = {"add", "subtract"};
    
    public int add(int x, int y) {
        System.out.println("In interiorul metodei 'add'");
        return x + y;
    }
    
    public int subtract(int x, int y) {
        System.out.println("In interiorul metodei 'subtract'");
        return x - y;
    }
    
    public int multiply(int x, int y) {
        return x * y;
    }
    
    public int divide(int x, int y) {
        return x / y;
    }
    
    public int divisionByZero(int x, int y) {
        int result = 0;
        try {
            // incercam o impartire la y
            result = x / y;
          // eroarea e aruncata
        } catch (ArithmeticException e) {
            //in situatia in care prindem aceasta eroare
            // nu dorim sa continuam executia
            fail("Impartirea la 0 nu este permisa");
        }
        
        return result;
    }
}
