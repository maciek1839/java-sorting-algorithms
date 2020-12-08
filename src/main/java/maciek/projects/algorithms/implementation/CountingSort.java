//package SortingAlgorithms.algorithms;
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class CountingSort implements Algorithm {
//    private final Random c_randomData;
//    private final int[] t_dataInt;
//
//    public CountingSort() {
//        c_randomData = new Random();
//        //we can also use interface's variable without its name
//        t_dataInt = new int[Algorithm.i_dataSize];
//    }
//    @Override
//    public long showUsage() {
//        inicializeTable();
//        long l_timeStart=0,l_timeFinish=0;;
//
//        try {
//            l_timeStart = System.currentTimeMillis();
//            sortData(t_dataInt);
//            l_timeFinish=System.currentTimeMillis();
//        } catch (NullPointerException e_nullPointer) {
//            System.out.println("Argument cannot be null!");
//        } catch (IllegalArgumentException e_illegalArgument) {
//            System.out.println("Table must be greater than one !");
//        }
//
//        return TimeUnit.SECONDS.convert(l_timeFinish-l_timeStart, TimeUnit.MILLISECONDS);
//    }
//
//    private void inicializeTable() {
//        for (int i = 0; i < i_dataSize; i++) {
//            t_dataInt[i] = c_randomData.nextInt()%i_maxRange;
//        }
//    }
//    @Override
//    public int[] sortData(int[] tData) throws NullPointerException, IllegalArgumentException {
//
//        if (tData == null)
//            throw new NullPointerException();
//        else if (tData.length == 0)
//            throw new IllegalArgumentException();
//
//        int i_theLowest=tData[0],i_theHighest=tData[0],i_listCapacity;
//
//        for(int i=0;i<tData.length;i++)
//        {
//            if(tData[i]<i_theLowest)
//                i_theLowest=tData[i];
//            else if(tData[i]>i_theHighest)
//                i_theHighest=tData[i];
//        }
//        i_listCapacity=i_theHighest-i_theLowest+1;//look at this 325-320=5 but 6 numbers->320,321,322,323,324,325
//        //array stores value from the lowest to the biggest
//        List<Pair<Integer,Integer>> l_lowHighValues=new ArrayList<Pair<Integer,Integer>>(i_listCapacity);
//        for(int i=0;i<i_listCapacity;i++)
//        {
//            l_lowHighValues.add(i,new Pair<Integer,Integer>(i_theLowest+i,0));
//        }
//        //count each value
//        for(int i=0;i<tData.length;i++)
//        {
//            l_lowHighValues.set(tData[i]-i_theLowest,new Pair<Integer,Integer>(l_lowHighValues.get(tData[i]-i_theLowest).getKey(),l_lowHighValues.get(tData[i]-i_theLowest).getValue()+1));
//
//        }
//        //flush all countered values
//        int i_howMany,i_tableIndex=0;
//        for(int i=0;i_tableIndex<tData.length&&i<i_listCapacity;i++)
//        {
//            i_howMany=l_lowHighValues.get(i).getValue();
//            if(i_howMany>0)
//            {
//                while(i_howMany>0)
//                {
//                    //System.out.println(i_tableIndex+"/"+i+"/"+l_lowHighValues.size());
//                    tData[i_tableIndex]=l_lowHighValues.get(i).getKey();
//                    i_howMany-=1;
//                    i_tableIndex+=1;
//                }
//            }
//        }
//        return tData;
//    }
//    /*
//    PSEUDOCODE
//        more on the Internet
//
//    PERFORMANCE
//       O(N+M) where N is the number of elements to be sorted and K is the number of possible values in the range.
//       but if we add first loop for searching the lowest and the highest value-> 2n+m
//       0(M)-memory
//     */
//    @Override
//    public String toString() {
//        return "Counting Sort ";
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode() + toString().hashCode();
//    }
//}
