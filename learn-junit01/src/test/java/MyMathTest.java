import junit.framework.TestCase;
import org.junit.*;

public class MyMathTest extends TestCase {

    @Before
    public void before(){
        System.out.println("Before");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }


    @Test
    public void test_sum_with_3_nums() {
            MyMath myMath = new MyMath();
            assertEquals(6, myMath.sum(new int[]{1,2,3}));
    }
    @Test
    public void test_sum_with_1_nums() {
        MyMath myMath = new MyMath();
        assertEquals(3, myMath.sum(new int[]{3}));
        assertTrue(true);
        assertFalse(false);
    }
}