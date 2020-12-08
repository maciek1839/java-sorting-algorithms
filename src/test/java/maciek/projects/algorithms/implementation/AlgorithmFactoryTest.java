//package SortingAlgorithms.algorithms;
//
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Maćko z Zarzecza on 2016-11-05.
// */
////also you can use MockitoAnnotations instead of RunWith
//@RunWith(MockitoJUnitRunner.class)
//public class AlgorithmFactoryTest {
//
//    @Mock
//    BubbleSort c_bubbleSort;
////    @Mock
////    CountingSort c_countingSort;
//    @Mock
//    HeapSort c_heapSort;
//    @Mock
//    InsertSort c_insertSort;
//    @Mock
//    MergeSort c_mergeSort;
//    @Mock
//    QuickSort c_quickSort;
//    @Mock
//    SelectionSort c_selectionSort;
//    @Mock
//    ShakerSort c_shakerSort;
//    @Mock
//    ShellSort c_shellSort;
//
//    AlgorithmFactory c_algorithmFactory;
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        System.out.println("Start testing AlgorithmFactory class.");
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        System.out.println("End testing AlgorithmFactory class");
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        c_algorithmFactory=new AlgorithmFactory();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        c_algorithmFactory=null;
//    }
//
//    @Test
//    public void createAlgorithmTest() throws Exception {
//        assertTrue(c_algorithmFactory.givePerformance(c_bubbleSort)=="O(N)/O(N^2)");
//        assertTrue(c_algorithmFactory.givePerformance(c_countingSort)=="O(N+M)");
//        assertTrue(c_algorithmFactory.givePerformance(c_insertSort)=="O(N)/O(N^2)");
//        assertTrue(c_algorithmFactory.givePerformance(c_mergeSort)=="O(N*LOG N)");
//    }
//
//    @Test
//    public void givePerformanceTest() throws Exception {
//
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.BUBBLE_SORT) instanceof BubbleSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.COUNTING_SORT) instanceof CountingSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.HEAP_SORT) instanceof HeapSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.INSERT_SORT) instanceof InsertSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.MERGE_SORT) instanceof MergeSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.QUICK_SORT) instanceof QuickSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.SELECTION_SORT) instanceof SelectionSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.SHAKER_SORT) instanceof ShakerSort);
//        assertTrue(c_algorithmFactory.createAlgorithm(Algorithms.SHELL_SORT) instanceof ShellSort);
//    }
//
//}
