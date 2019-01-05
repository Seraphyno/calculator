package calculator;

import static org.junit.Assert.*;

import org.junit.*;

import org.junit.rules.ExpectedException;
import org.junit.runners.model.TestTimedOutException;

public class CalculatorTest {
    
    Calculator target = new Calculator();
    
    @Rule
    public ExpectedException expectException = ExpectedException.none();
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Inaintea tuturor testelor");
    }
    
    @Before
    public void setup() {
        System.out.println("Inaintea fiecarui test");
    }
    
    @Test
    public void testAdd() {
//        assert 5 == 5;
        // java style
        assert target.add(1,2) == 3;
        
        // junit style
        assertEquals(3, target.add(1,2));
//        assertEquals("Rezultatul nu este cel dorit!", 4, target.add(1,2));
    }
    
    @Test
    public void testMultiply() {
        assertEquals(6, target.multiply(3, 2));
    }
    
    @Test
    public void testDivide() {
//        assertEquals(6, target.divide(12, 2));
        
        expectException.expect(ArithmeticException.class);
        expectException.expectMessage("/ by zero");
        target.divide(100, 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivideShouldThrow() {
        target.divide(100, 0);
    }
    
    @Test
    public void testDivisionByZero() {
        target.divisionByZero(12, 3);
//        target.divisionByZero(12, 0);
    }
    
    @Test
    public void testConstructor() {
        Object obiect = null;
        
        assertNotNull(target);
//        assertNotNull("Obiectul nu este initializat", obiect);
        
        assertNull(obiect);
    }
    
    @Ignore("Testele pica deoarece s-a schimbat functionalitatea")
    @Test
    public void testMembers() {
       assertEquals(true, target.isActive);
       assertTrue(target.isActive);
//       assertTrue("Variabila este falsa", !target.isActive);
    
        String[] verificare = {"add", "subtract"};
        assertArrayEquals(new String[] {"add", "subtract"}, target.methods);
    }
    
    @Test(timeout = 100L)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("In afara metodei sleep()");
    }
    
    @Test(timeout = 1000L, expected = NullPointerException.class)
    public void testBothTestParams() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("In afara metodei sleep()");
        
        throw new NullPointerException();
    }
    
    @After
    public void breakdown() {
        System.out.println("Dupa fiecare test");
    }
    
    @AfterClass
    public static void afterClass() {
        System.out.println("Dupa incheierea testelor");
    }
    
}