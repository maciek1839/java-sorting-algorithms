package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShellSort implements Algorithm{

    private final Random c_randomData;
    private final int[] t_dataInt;

    public ShellSort()
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

        int i_valToSwap,i_hole=tData.length/2;
        //start from top to down
        while(i_hole>0) {
            for (int j = i_hole; j < tData.length; j++) {
                if (tData[j] < tData[j-i_hole])
                {
                    i_valToSwap=tData[j];
                    tData[j]=tData[j-i_hole];
                    tData[j-i_hole]=i_valToSwap;
                    for(int i=0;i_hole==1&&j-i_hole-1-i>=0&&tData[j-i_hole-i]<tData[j-i_hole-i-1];i++)
                    {
                        i_valToSwap=tData[j-i_hole-i];
                        tData[j-i_hole-i]=tData[j-i_hole-i-1];
                        tData[j-i_hole-i-1]=i_valToSwap;
                    }
                }
            }
            i_hole=i_hole/2;
        }
        //now when the array is parted sorted, we sort all elements like InsertSort

        /*int j;
        for( int gap = tData.length / 2; gap > 0; gap /= 2 )
        {
            for( int i = gap; i < tData.length; i++ )
            {
                int tmp = tData[ i ];
                for( j = i; j >= gap && tmp<tData[ j - gap ]  ; j -= gap )
                {
                    tData[ j ] = tData[ j - gap ];
                }
                tData[ j ] = tmp;
            }
        }*/

        return tData;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
        depends on paramatere i_hole
        Stability? Yes
     */
    @Override
    public String toString() {
        return "Shell Sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode()+toString().hashCode();
    }
}
