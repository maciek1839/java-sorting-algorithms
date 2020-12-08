package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SelectionSort implements Algorithm{

    private final Random c_randomData;
    private final int[] t_dataInt;

    public SelectionSort()
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
    public int[] sortData(int[] tData) throws NullPointerException, IllegalArgumentException {

        if(tData == null)
            throw new NullPointerException();
        else if(tData.length == 0)
            throw new IllegalArgumentException();

        int i_positionToSwap,i_valSwapped;

        for(int i=0;i<tData.length;i++)
        {
            i_positionToSwap=i;
            for(int j=i;j<tData.length;j++)
                if(tData[i_positionToSwap]>tData[j])
                    i_positionToSwap=j;

            i_valSwapped=tData[i];
            tData[i]=tData[i_positionToSwap];
            tData[i_positionToSwap]=i_valSwapped;
        }
        return tData;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n^{2})
        Worst-case space complexity	O(1)
        Stability? No
     */
    @Override
    public String toString() {
        return "Selection Sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
