import org.junit.Test;
import ru.sberbank.edu.GCD;
import ru.sberbank.edu.GreetingImpl;

import static org.junit.Assert.assertEquals;

public class JUnitTest {

    @Test
    public void testHobby() {
        String myHobby = "Sport";
        GreetingImpl impl = new GreetingImpl();
        assertEquals("Test GreetingImpl",myHobby, impl.getBestHobby());
    }

    @Test
    public void testGCD() {
        GCD gcd = new GCD();
        assertEquals("Test1 GCD", 4, gcd.getDivisor(12,8));
        assertEquals("Test2 GCD", 12, gcd.getDivisor(36,48));
    }
}
