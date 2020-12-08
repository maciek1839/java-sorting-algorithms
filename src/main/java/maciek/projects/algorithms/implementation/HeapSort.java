package maciek.projects.algorithms.implementation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HeapSort implements Algorithm {
    private final Random c_randomData;
    private final int[] t_dataInt;

    public HeapSort() {
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
        } catch (NullPointerException e_nullPointer) {
            System.out.println("Argument cannot be null!");
        } catch (IllegalArgumentException e_illegalArgument) {
            System.out.println("Table must be greater than one !");
        }
        return TimeUnit.SECONDS.convert(l_timeFinish-l_timeStart, TimeUnit.MILLISECONDS);
    }

    private void inicializeTable() {
        for (int i = 0; i < i_dataSize; i++) {
            t_dataInt[i] = c_randomData.nextInt()%i_maxRange;
        }
    }
    @Override
    public int[] sortData(int[] tData) throws NullPointerException, IllegalArgumentException {

        if (tData == null)
            throw new NullPointerException();
        else if (tData.length == 0)
            throw new IllegalArgumentException();

        //create max heap
        for(int i=1;i<=tData.length;i++)
            tData=createMaxHeap(tData,i);
        //strip heap
        int i_tmp;
        for(int i=0;i<tData.length;i++)
        {
            i_tmp=tData[tData.length-1-i];
            tData[tData.length-1-i]=tData[0];
            tData[0]=i_tmp;
            tData=checkChildren(tData,0,tData.length-i-1);
        }
        return tData;
    }

    private int[] createMaxHeap(int[] tData, int amountElements) {
        int i_tmp;
        for(int i=1;i<amountElements;i++) {

            if(tData[i/2]<tData[i])
            {
                i_tmp=tData[i];
                tData[i]=tData[i/2];
                tData[i/2]=i_tmp;
                checkParent(tData,i/2);//check higher levels
            }
        }
        return tData;
    }

    //change order up in heap if necessary
    private int[] checkParent(int[] t_heap, int i) {
        int i_tmp,i_parent=i/2;
        while(i!=0&&i_parent>=0) {
            if (t_heap[i] > t_heap[i_parent]) {
                i_tmp = t_heap[i];
                t_heap[i] = t_heap[i_parent];
                t_heap[i_parent] = i_tmp;
                i=i_parent;
                i_parent=i_parent/2;
            }
            else break;
        }
        return t_heap;
    }
    //change order down in heap if necessary
    private int[] checkChildren(int[] t_heap, int i,int i_amountElements) {

            if(i_amountElements>0&&i<i_amountElements) {
                int i_tmp,i_left,i_right;
                i_left=2*i;
                i_right=2*i+1;
                if (i_left < i_amountElements && t_heap[i] < t_heap[i_left]) {
                    i_tmp = t_heap[i];
                    t_heap[i] = t_heap[i_left];
                    t_heap[i_left] = i_tmp;
                    t_heap=checkChildren(t_heap, i_left,i_amountElements);
                }
                if (i_right < i_amountElements && t_heap[i] < t_heap[i_right]) {
                    i_tmp = t_heap[i];
                    t_heap[i] = t_heap[i_right];
                    t_heap[i_right] = i_tmp;
                    t_heap=checkChildren(t_heap, i_right, i_amountElements);
                }
            }
        return t_heap;
    }
    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
       Worst-case performance O(n log n) -> because we iterate through all elements(n) and
       Best-case performance  O(n log n)
       Worst-case space complexity: O(1)
     */
    @Override
    public String toString() {
        return "Heap Sort ";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + toString().hashCode();
    }
}
