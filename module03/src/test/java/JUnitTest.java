import org.junit.Test;
import ru.sberbank.edu.CustomArrayImpl;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class JUnitTest {
    @Test
    public void CustomArrayImpl() {

        CustomArrayImpl customArray = new CustomArrayImpl();

        assertEquals("TestIsEmpty1 customArray", true, customArray.isEmpty());
        assertEquals("TestAdd customArray", true, customArray.add("Test"));
        assertEquals("TestAdd1 customArray", true, customArray.add("Test1"));
        assertEquals("TestSize customArray", 2, customArray.size());
        assertEquals("TestGet customArray", "Test", customArray.get(0));
        assertEquals("TestIsEmpty2 customArray", false, customArray.isEmpty());
        assertEquals("TestSet customArray", "Test", customArray.set(0, "Test3"));
        assertEquals("TestGet customArray", "Test3", customArray.get(0));
        assertEquals("TestContains customArray", false, customArray.contains("Test"));
        assertEquals("TestContains1 customArray", true, customArray.contains("Test3"));
        assertEquals("TestRemove customArray", true, customArray.remove("Test3"));
        assertEquals("TestContains2 customArray", false, customArray.contains("Test3"));
        assertEquals("TestGetCapacity customArray", 10, customArray.getCapacity());

    }
}