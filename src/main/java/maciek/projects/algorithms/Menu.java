package maciek.projects.algorithms;

import maciek.projects.algorithms.implementation.*;

import java.util.Scanner;

public class Menu {

    private final BubbleSort c_BubbleSort;
//    private final CountingSort c_CountingSort;
    private final HeapSort c_HeapSort;
    private final InsertSort c_InsertSort;
    private final MergeSort c_MergeSort;
    private final QuickSort c_QuickSort;
    private final SelectionSort c_SelectionSort;
    private final ShakerSort c_ShakerSort;
    private final ShellSort c_ShellSort;
    private final AlgorithmFactory c_algorithmFactory;
    private int i_userChoice;
    private Waiting c_printPoint;
    private final StringBuilder c_strBuilderMenu;
    private final Scanner c_scannerChoice;

    Menu()
    {
        c_algorithmFactory=new AlgorithmFactory();
        c_BubbleSort= (BubbleSort)c_algorithmFactory.createAlgorithm(Algorithms.BUBBLE_SORT);
//        c_CountingSort=(CountingSort)c_algorithmFactory.createAlgorithm(Algorithms.COUNTING_SORT);
        c_HeapSort=(HeapSort)c_algorithmFactory.createAlgorithm(Algorithms.HEAP_SORT);
        c_InsertSort=(InsertSort)c_algorithmFactory.createAlgorithm(Algorithms.INSERT_SORT);
        c_MergeSort=(MergeSort)c_algorithmFactory.createAlgorithm(Algorithms.MERGE_SORT);
        c_QuickSort=(QuickSort)c_algorithmFactory.createAlgorithm(Algorithms.QUICK_SORT);
        c_SelectionSort=(SelectionSort)c_algorithmFactory.createAlgorithm(Algorithms.SELECTION_SORT);
        c_ShakerSort=(ShakerSort)c_algorithmFactory.createAlgorithm(Algorithms.SHAKER_SORT);
        c_ShellSort=(ShellSort)c_algorithmFactory.createAlgorithm(Algorithms.SHELL_SORT);
        c_strBuilderMenu=new StringBuilder();
        c_scannerChoice = new Scanner(System.in);
    }
    public void startApp()
    {
        while(i_userChoice!=11) {
            createMenu();
        }
    }
    private void createMenu()
    {
        c_strBuilderMenu.append("\n");
        c_strBuilderMenu.append("1.Bubble Sort\n");
        c_strBuilderMenu.append("2.Counting Sort\n");
        c_strBuilderMenu.append("3.Heap Sort\n");
        c_strBuilderMenu.append("4.Insertion Sort\n");
        c_strBuilderMenu.append("5.Merge Sort\n");
        c_strBuilderMenu.append("6.Quick Sort\n");
        c_strBuilderMenu.append("7.Selection Sort\n");
        c_strBuilderMenu.append("8.Shaker Sort\n");
        c_strBuilderMenu.append("9.Shell Sort\n");
        c_strBuilderMenu.append("11. Exit program\n");
        c_strBuilderMenu.append("What would you like to try?\tPlease choice one option:\n");
        System.out.print(c_strBuilderMenu.toString());
        //reset stringBuilder
        c_strBuilderMenu.setLength(0);
        do{
            i_userChoice = userChoice(c_scannerChoice.next());
        }while(!handleUserChoice(i_userChoice));
    }
    //0 is value for bad user's input
    private int userChoice(String s_choice)
    {
        int i_result;
        if(s_choice.equals("11"))
            i_result=11;
        else if(s_choice.length()>1 || s_choice.matches("(.*)[a-zA-Z](.*)"))
            i_result=0;
        else
            i_result=Integer.parseInt(s_choice);
        return i_result;
    }
    private boolean handleUserChoice(int i_choice)
    {
        boolean b_result=true;
        switch(i_choice)
        {
            case 1:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_BubbleSort.toString()+"    Time: "+c_BubbleSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 2:
                c_printPoint=new Waiting();
                c_printPoint.start();
//                System.out.println("\nName: "+c_CountingSort.toString()+"    Time: "+c_CountingSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 3:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_HeapSort.toString()+"    Time: "+c_HeapSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 4:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+ c_InsertSort.toString()+"    Time: "+ c_InsertSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 5:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_MergeSort.toString()+"    Time: "+c_MergeSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 6:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_QuickSort.toString()+"    Time: "+c_QuickSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 7:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_SelectionSort.toString()+"    Time: "+c_SelectionSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 8:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+c_ShakerSort.toString()+"    Time: "+c_ShakerSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 9:
                c_printPoint=new Waiting();
                c_printPoint.start();
                System.out.println("\nName: "+ c_ShellSort.toString()+"    Time: "+ c_ShellSort.showUsage()+" s");
                System.out.println("Number of elements: "+Algorithm.i_dataSize+"    Ranging from "+"-"+(Algorithm.i_maxRange-1)+" to "+(Algorithm.i_maxRange-1));
                c_printPoint.setDone();
                break;
            case 11:
                System.out.println("Thank you and see you again!");
                //do nothing because it is exit code
                break;
            default:
                System.out.print("Bad value, try again!\n");
                b_result=false;
        }
        return b_result;
    }
}
