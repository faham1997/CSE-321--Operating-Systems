package Scheduling;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Runner runner = new Runner();
            runner.InputValue();
            runner.ProcessRun();
            runner.PrintSequence();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
