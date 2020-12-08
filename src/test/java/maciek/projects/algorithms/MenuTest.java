package maciek.projects.algorithms;

import org.junit.*;
import org.powermock.reflect.Whitebox;

/**
 * Created by Maćko z Zarzecza on 2016-11-02.
 */
public class MenuTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Start testing Waiting class.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("End testing Waiting class");
    }

    @Test
    public void userChoiceIfBadInputTest() throws Exception {

        int result = Whitebox.invokeMethod(new Menu(),"userChoice","asd");
        Assert.assertEquals("Output should be 0 due to bad user's input like 'abcd'.",0, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","qwe123awe");
        Assert.assertEquals("Output should be 0 due to bad user's input like 'abcd'.",0, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","1a");
        Assert.assertEquals("Output should be 0 due to bad user's input like 'a22cd'.",0, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","a2");
        Assert.assertEquals("Output should be 0 due to bad user's input like 'ab3d'.",0, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","10");
        Assert.assertEquals("Output should be 0 because menu doesn't have 10 like an option.",0, result);
    }
    @Test
    public void userChoiceCorrectInputTest() throws Exception {

        int result = Whitebox.invokeMethod(new Menu(),"userChoice","1");
        Assert.assertEquals(1, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","2");
        Assert.assertEquals(2, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","4");
        Assert.assertEquals(4, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","5");
        Assert.assertEquals(5, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","8");
        Assert.assertEquals(8, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","9");
        Assert.assertEquals(9, result);
        result = Whitebox.invokeMethod(new Menu(),"userChoice","11");
        Assert.assertEquals(11, result);
    }
}
