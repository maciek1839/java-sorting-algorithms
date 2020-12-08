package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShakerSort implements Algorithm{

    private final Random c_randomData;
    private final int[] t_dataInt;

    public ShakerSort()
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
    public int[] sortData(int[] tData) throws NullPointerException,IllegalArgumentException {

            if(tData == null)
            throw new NullPointerException();
        else if(tData.length == 0)
            throw new IllegalArgumentException();

        int i_valToSwap,i_loop=0;//i_loop means the same as int i in for loop
        boolean b_swapped;

       do
       {
           b_swapped=false;
           for(int j=i_loop;j<tData.length-i_loop-1;j++)
           {
               if(tData[j]>tData[j+1])
               {
                   i_valToSwap=tData[j];
                   tData[j]=tData[j+1];
                   tData[j+1]=i_valToSwap;
                   b_swapped=true;
               }
           }
           //means that array is sorted and we dont have to do more comparisions
           if(!b_swapped) break;
           for(int j=tData.length-i_loop-1;j>i_loop;j--)
           {
               if(tData[j]<tData[j-1])
               {
                   i_valToSwap=tData[j];
                   tData[j]=tData[j-1];
                   tData[j-1]=i_valToSwap;
                   b_swapped=true;
               }
           }
           i_loop++;
       }while(b_swapped);

        return tData;
    }
    /*
    PSEUDOCODE
        Shaker sort (bidirectional bubble sort)

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n)
        Worst-case space complexity O(1)
        Stability? Yes
     */
    @Override
    public String toString() {
        return "Shaker Sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
