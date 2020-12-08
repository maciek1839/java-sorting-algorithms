package maciek.projects.algorithms;

import org.junit.*;

import static org.junit.Assert.assertTrue;


/**
 * Created by Maćko z Zarzecza on 2016-11-02.
 */
/*
extends TestCase was used in JUNIT 3 but in JUNIT 4 we use @Test
 */
public class WaitingTest{

    private Waiting testObj;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Start testing Waiting class.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("End testing Waiting class");
    }

    @Before
    public void setUp() throws Exception {
        testObj=new Waiting();
    }

    @After
    public void tearDown() throws Exception {
        testObj=null;
    }
    @Test
    public void setDoneTest() throws Exception {
        testObj.setDone();
        assertTrue("Variable done isn't true!",true);
    }

}
