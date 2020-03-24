package timeclass;

public class timedriver
{
    public static void main(String[] args)
    {
        time main = new time(4,50,30);

        //get hour
        System.out.println(main.getHour());

        //get min
        System.out.println(main.getMinute());

        //get second
        System.out.println(main.getSecond());

        //set hour
        main.setHour(10);

        //set minute
        main.setMinute(10);

        //set second
        main.setSecond(10);

        //set time
        main.setTime(2,2,2);

        //to string
        System.out.println(main.toString());

        // next sec
        main.nextSecond();

        //prev sec
        main.previousSecond();

    }
};