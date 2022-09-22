
/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * windows 10
 */
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.Test;

public class TestMain {

    @Test
    public void testMain1() throws Exception {
        JFrame testFrame = new JFrame();
        ArrayList<Double> testList = new ArrayList<Double>(0);

        testList.add(100.0);
        testList.add(100.0);
        testList.add(100.0);

        assertEquals(100.0, Main.averageExpenses(testList, testFrame), 0.01);
    }

    @Test
    public void testMain2() throws Exception {
        JFrame testFrame = new JFrame();
        ArrayList<Double> testList = new ArrayList<Double>(0);

        testList.add(50.0);
        testList.add(60.0);
        testList.add(100.0);

        assertEquals(70.00, Main.averageExpenses(testList, testFrame), 0.01);
    }

    @Test
    public void testMain3() throws Exception {
        JFrame testFrame = new JFrame();
        ArrayList<Double> testList = new ArrayList<Double>(0);

        testList.add(70000.0);
        testList.add(60000.0);
        testList.add(100000.0);

        assertEquals(76666.67, Main.averageExpenses(testList, testFrame), 0.01);
    }
}
