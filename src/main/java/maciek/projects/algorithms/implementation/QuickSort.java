package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuickSort implements Algorithm{

    private final Random c_randomData;
    private final int[] t_dataInt;

    public QuickSort()
    {
        c_randomData=new Random();
        //we can also use interface's variable without its name
        t_dataInt=new int[i_dataSize];
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

        tData=sortWithPivot(tData,0,tData.length-1);

        return tData;
    }
    //we use index of table's elements!
    private int[] sortWithPivot(int[] tData,int from, int to) {

        int i_left=from, i_right=to;
        int tmp;
        int pivot=tData[(from+to)/2];

        while (i_left<=i_right) {
            while (tData[i_left]<pivot)
                i_left++;
            while (tData[i_right]>pivot)
                i_right--;
            if (i_left<=i_right) {
                tmp = tData[i_left];
                tData[i_left] = tData[i_right];
                tData[i_right] = tmp;
                i_left++;
                i_right--;
            }
        }

        if (from<i_right)
            sortWithPivot(tData,from,i_right);
        if (i_left<to)
            sortWithPivot(tData,i_left,to);
        return tData;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
       Worst-case performance O(n^2)
       Best-case performance  O(n log n)
       Worst-case space complexity O(1)
     */
    @Override
    public String toString() {
        return "Quick sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
