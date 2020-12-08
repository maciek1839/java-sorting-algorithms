package maciek.projects.algorithms.implementation;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Maćko z Zarzecza on 2016-11-05.
 */
public class QuickSortTest {
    private QuickSort quickSort;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Start testing QuickSort class.");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("End testing QuickSort class");
    }

    @Before
    public void setUp() throws Exception {
        quickSort=new QuickSort();
    }

    @After
    public void tearDown() throws Exception {
        quickSort=null;
    }

    @Test(expected=NullPointerException.class)
    public void sortDataNull(){
        int [] tableNull=null;
        quickSort.sortData(tableNull);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sortDataZeroLength(){
        int [] tableZero=new int[0];
        quickSort.sortData(tableZero);
    }

    @Test
    public void sortData() throws Exception {
        int [] table1=new int[]{4,6,2,4,3,1};
        assertArrayEquals(new int[]{1,2,3,4,4,6},quickSort.sortData(table1));
        table1=new int[]{1,2,3,4,4,5};
        assertArrayEquals(new int[]{1,2,3,4,4,5},quickSort.sortData(table1));
        table1=new int[]{-1,2,3,4,-4,5,25,-30};
        assertArrayEquals(new int[]{-30,-4,-1,2,3,4,5,25},quickSort.sortData(table1));
        table1=new int[]{5,5,5,5,5,5,1,5,5,5};
        assertArrayEquals(new int[]{1,5,5,5,5,5,5,5,5,5},quickSort.sortData(table1));
        table1=new int[]{4,423,6,6,-2,0,43,-423,53432,23,4423};
        assertArrayEquals(new int[]{-423,-2,0,4,6,6,23,43,423,4423,53432},quickSort.sortData(table1));
        table1=new int[]{4,77,5,4,33,5,7,8,9,9,9,96,5,54,33,55,3,2};
        assertArrayEquals(new int[]{2,3,4,4,5,5,5,7,8,9,9,9,33,33,54,55,77,96},quickSort.sortData(table1));
    }

    @Test
    public void toStringTest(){
        String result="Quick sort ";
        assertTrue(quickSort.toString().equals(result));
    }
}
