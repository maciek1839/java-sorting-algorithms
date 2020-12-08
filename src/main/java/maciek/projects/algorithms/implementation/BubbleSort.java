package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BubbleSort implements Algorithm {

    private final Random c_randomData;
    private final int[] t_dataInt;

    public BubbleSort()
    {
        c_randomData=new Random();
        //we can also use interface's variable without its name
        t_dataInt=new int[Algorithm.i_dataSize];
    }
    @Override
    public long showUsage() {
        inicializeTable();
        long l_timeStart=0,l_timeFinish=0;
        try {
            l_timeStart = System.currentTimeMillis();
            sortData(t_dataInt);
            l_timeFinish=System.currentTimeMillis();
        }
        catch(NullPointerException e_nullPointer)
        {
            System.out.println("Argument cannot be null!");
        }
        catch(IllegalArgumentException e_illegalArgument)
        {
            System.out.println("Table must be greater than one !");
        }
        return TimeUnit.SECONDS.convert(l_timeFinish-l_timeStart, TimeUnit.MILLISECONDS);
    }

    private void inicializeTable() {
        for (int i = 0; i < i_dataSize; i++) {
            t_dataInt[i]=c_randomData.nextInt()%i_maxRange;
        }
    }
    @Override
    public int[] sortData(int[] tData) throws NullPointerException, IllegalArgumentException{

        if(tData == null)
            throw new NullPointerException();
        else if(tData.length == 0)
            throw new IllegalArgumentException();

        int i_valToSwap;
        boolean b_swapped=true;

        for(int i = 0; i < tData.length-1 && b_swapped; i++) {
            b_swapped=false;
            for (int j = 0; j < tData.length-i-1; j++) {
                if (tData[j] > tData[j+1])
                {
                    i_valToSwap=tData[j];
                    tData[j]=tData[j+1];
                    tData[j+1]=i_valToSwap;
                    b_swapped=true;
                }
            }
        }
        return tData;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n)
        Worst-case space complexity O(1)
        Stability? Yes

        Case 1) O(n^2) (Worst case) The worst case is if the array is already sorted but in descending order.
        This means that in the first iteration it would have to look at n elements,
        then after that it would look n - 1 elements (since the biggest integer is at the end)
        and so on and so forth till 1 comparison occurs. Big Oh = n + n - 1 + n - 2 ... + 1 = (n*(n + 1))/2 = O(n^2)(approximation)

        Case 2) O(n) (Best case) This time complexity can occur if the array is already sorted,
        and that means that no swap occurred and only 1 iteration of n elements
    */
    @Override
    public String toString() {
        return "Bubble Sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
