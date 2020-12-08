package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MergeSort implements Algorithm{

    private final Random c_randomData;
    private final int[] t_dataInt;

    public MergeSort()
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

        for(int i_partSize=1;i_partSize<tData.length;i_partSize=i_partSize*2)
            tData=mergeParts(tData,i_partSize);
        return tData;
    }

    private int[] mergeParts(int[] tData, int i_partSize) {

        int i_leftPart=0,i_leftStart=0,i_rightStart=i_partSize,i_rightPart=i_partSize;
        int [] t_sortedElements=new int[tData.length];
            for(int i=0;i<tData.length;i++)
            {
                if(i_leftStart-i_leftPart==i_partSize&&i_rightStart-i_rightPart!=i_partSize)
                {
                    t_sortedElements[i] = tData[i_rightStart];
                    i_rightStart++;
                }
                else if((i_rightStart-i_rightPart==i_partSize||i_rightStart>=tData.length)&&i_leftStart-i_leftPart<i_partSize)
                {
                    t_sortedElements[i] = tData[i_leftStart];
                    i_leftStart++;
                }
                else if(tData[i_leftStart]<tData[i_rightStart]) {
                    t_sortedElements[i] = tData[i_leftStart];
                    i_leftStart++;
                }
                else {
                    t_sortedElements[i] = tData[i_rightStart];
                    i_rightStart++;
                }
                //check if each segmenet's element was compared
                if(i_leftStart-i_leftPart==i_partSize&&i_rightStart-i_rightPart==i_partSize)
                {
                    i_leftPart+=2*i_partSize;
                    i_leftStart=i_leftPart;
                    i_rightPart+=2*i_partSize;
                    i_rightStart=i_rightPart;
                }
            }
        return t_sortedElements;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
       Worst-case performance O(n log n)
       Best-case performance  O(n log n)
       Worst-case space complexity O(n)

     */
    @Override
    public String toString() {
        return "Merge sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
