package maciek.projects.algorithms;

import static java.lang.Thread.sleep;

public class Waiting extends Thread{

    //This class print point every second during algoritm is wokring.

    volatile private  boolean isDone;
    Waiting()
    {
        isDone=false;
    }

    public void setDone() {
        isDone = true;
    }

    @Override
    public void run() {
        System.out.println("Please wait ");
        long l_counter = 0;
        while (!isDone) {
            if (l_counter % 100000000 == 0)
                System.out.print(".");
            l_counter++;
        }
    }
    public boolean isDone()
    {
        return isDone;
    }
}
