package Scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner
{
    List<Process> processArrayList = new ArrayList<>();
    ArrayList<String> sequence = new ArrayList<>();
    int n = 0;

    public void InputValue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Number of LProcess:");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("Burst Time:");
            int btime = scanner.nextInt();
            System.out.println("Priority:");
            int atime = scanner.nextInt();
            Process process = new Process();
            process.time = btime;
            process.id = i;
            process.priority = atime;
            processArrayList.add(process);
        }
    }

    Process v;

    public void ProcessRun() throws InterruptedException
    {
        for (int i = 0; check(); i++)
        {
            v = processArrayList.get(getMaxPriorityIndex());
            if (v.time == 1)
                processArrayList.remove(getMaxPriorityIndex());
            else
                processArrayList.get(getMaxPriorityIndex()).time--;

            sequence.add(v.id + "");
        }
    }


    public int getMaxPriorityIndex()
    {
        int index = 0;
        Process tt = processArrayList.get(0);
        for (int i = 1; i < processArrayList.size(); i++)
        {
            if (processArrayList.get(i).priority < tt.priority)
            {
                tt = processArrayList.get(i);
                index = i;
            }
        }
        return index;

    }

    public boolean check()
    {
        int b = 0;
        for (Process p : processArrayList)
        {
            if (p.time <= 0)
                b++;
        }
        if (b == processArrayList.size())
            return false;
        else
            return true;
    }


    public void PrintSequence()
    {
        System.out.println("Process sequence:");
        for (String ss : sequence)
        {
            System.out.println(ss);
        }
    }
}
