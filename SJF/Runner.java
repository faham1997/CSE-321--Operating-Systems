package Scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner
{
    List<Process> processArrayList = new ArrayList<>();
    List<Process> arrivalList = new ArrayList<>();
    ArrayList<String> sequence = new ArrayList<>();
    int n = 0;

    public void InputValue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Number of Process:");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("Arrival Time:");
            int atime = scanner.nextInt();

            System.out.println("Burst Time:");
            int btime = scanner.nextInt();
            Process process = new Process();
            process.time = btime;
            process.id = i;
            process.arrivalTime = atime;
            processArrayList.add(process);
        }
    }

    Process v;

    public void ProcessRun() throws InterruptedException
    {
        for (int i = 0; check(); i++)
        {
            if (arrivalList(i)) //preempt and do job
            {
                if (getMin() != -1)
                {
                    v = arrivalList.get(getMin());
                    if (v.time == 1)
                        arrivalList.remove(getMin());
                    else
                        arrivalList.get(getMin()).time--;

                    sequence.add(v.id + "");
                }

            } else
            {
                v = arrivalList.get(getMin());
                for (int k = 0; k < arrivalList.size(); k++)
                {
                    if (arrivalList.get(k).id == v.id)
                    {
                        if (arrivalList.get(k).time == 1)
                        {
                            arrivalList.get(k).time--;
                            arrivalList.remove(k);
                        } else
                            arrivalList.get(k).time--;
                    }
                }

                sequence.add(v.id + "");
            }
        }

    }

    public boolean arrivalList(int t)
    {
        boolean b = false;

        for (Process p : processArrayList)
        {
            if (p.arrivalTime == t)
            {
                arrivalList.add(p);
                return true;
            } else b = false;
        }
        return b;
    }

    public int getMin()
    {
        int p = -1;
        if (arrivalList.size() == 0)
            return -1;
        else if (arrivalList.size() == 1)
            return 0;
        else
        {
            p = 0;
            Process tt = arrivalList.get(0);
            for (int i = 1; i < arrivalList.size(); i++)
            {
                if (arrivalList.get(i).time < tt.time)
                {
                    tt = arrivalList.get(i);
                    p = i;
                }
            }
            return p;
        }
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
