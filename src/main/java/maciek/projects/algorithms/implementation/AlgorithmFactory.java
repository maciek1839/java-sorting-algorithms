package maciek.projects.algorithms.implementation;

public class AlgorithmFactory implements AbstractAlgorithmFactory {

    @Override
    public Algorithm createAlgorithm(Algorithms enumVal) {

        Algorithm c_result=null;

        switch(enumVal)
        {
            case BUBBLE_SORT:
                c_result=new BubbleSort();
                break;
//            case COUNTING_SORT:
//                c_result=new CountingSort();
//                break;
            case HEAP_SORT:
                c_result=new HeapSort();
                break;
            case INSERT_SORT:
                c_result=new InsertSort();
                break;
            case MERGE_SORT:
                c_result=new MergeSort();
                break;
            case QUICK_SORT:
                c_result=new QuickSort();
                break;
            case SELECTION_SORT:
                c_result=new SelectionSort();
                break;
            case SHAKER_SORT:
                c_result=new ShakerSort();
                break;
            case SHELL_SORT:
                c_result=new ShellSort();
                break;
        }
        return c_result;
    }

    @Override
    public String givePerformance(Algorithm algorithmVal) {

        String s_result=null;
        StringBuffer sb_stringBuffer=new StringBuffer();

        if(algorithmVal instanceof BubbleSort)
        {
            s_result="O(N)/O(N^2)";
        }
//        else  if(algorithmVal instanceof CountingSort)
//        {
//            s_result="O(N+M)";
//        }
        else if(algorithmVal instanceof HeapSort)
        {
            s_result="O(N*LOG N)";
        }else if(algorithmVal instanceof InsertSort)
        {
            s_result="O(N)/O(N^2)";
        }else if(algorithmVal instanceof MergeSort)
        {
            s_result="O(N*LOG N)";
        }else if(algorithmVal instanceof QuickSort)
        {
            s_result="O(N*LOG N)/O(N^2)";
        }else if(algorithmVal instanceof SelectionSort)
        {
            s_result="O(N^2)";
        }else if(algorithmVal instanceof ShakerSort)
        {
            s_result="O(N)/O(N^2)";
        }else if(algorithmVal instanceof ShellSort)
        {
            s_result="OUNDEFINED";
        }
        return s_result;
    }

}
