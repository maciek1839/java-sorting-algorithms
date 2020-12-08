package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertSort implements Algorithm {

    private final Random c_randomData;
    private final int[] t_dataInt;

    public InsertSort() {
        c_randomData = new Random();
        //we can also use interface's variable without its name
        t_dataInt = new int[Algorithm.i_dataSize];
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
    public int[] sortData(int[] tData) throws NullPointerException, IllegalArgumentException {
        if(tData == null)
            throw new NullPointerException();
        else if(tData.length == 0)
            throw new IllegalArgumentException();

        int i_swapped;
        for(int i=tData.length-1;i>0;i--)
        {
            for(int j=i;j<tData.length&&tData[j-1]>tData[j];j++)
                {
                    i_swapped=tData[j-1];
                    tData[j-1]=tData[j];
                    tData[j]=i_swapped;
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
    */
    @Override
    public String toString() {
        return "Insertion sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
