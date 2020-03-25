package Scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner
{
    List<Process> processes = new ArrayList<>();
    int n = 0;

    public void InputValue()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Number of Process:");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("Process Time:");
            int time = scanner.nextInt();
            Process process = new Process();
            process.Time = time;
            process.Id = i;
            processes.add(process);
        }
    }

    public void ProcessRun() throws InterruptedException
    {

        int st = 0;
        int end = 0;
        for (int i = 0; i < processes.size(); i++)
        {
            processes.get(i).WaitTime = end;
            processes.get(i).StartTime = st;
            processes.get(i).EndTime = st + processes.get(i).Time;
            end = processes.get(i).EndTime;
            st = processes.get(i).EndTime;
        }
    }

    public void PrintResult()
    {
        for (int i = 0; i < processes.size(); i++)
        {
            System.out.println("------------------------------------");
            System.out.println("Id   Time   WaitT   StartT    EndT");
            System.out.println("------------------------------------");
            System.out.println(processes.get(i).Id + "     " + processes.get(i).Time + "      " + processes.get(i).WaitTime + "       " + processes.get(i).StartTime + "       " + processes.get(i).EndTime);

        }
    }
}
