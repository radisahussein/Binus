package timeclass;

public class time
{
    private int hour;
    private int minute;
    private int second;

    public time(int hour, int minute, int second)
    {
        if (hour >= 0 && hour<= 23)
        {
            if (minute >= 0 && minute <= 59)
            {
                if (second >= 0 && second <= 59)
                {
                    this.hour = hour;
                    this.minute = minute;
                    this.second = second;
                }
            }
        }
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void setHour(int hour)
    {
        if (hour >= 0 && hour <= 23)
        {
            this.hour = hour;
        }
    }

    public void setMinute(int minute)
    {
        if (minute >= 0 && minute <= 59)
        {
            this.minute = minute;
        }
    }

    public void setSecond(int second)
    {
        if (second >= 0 && second <= 23)
        {
            this.second = second;
        }
    }

    public void setTime(int hour,int minute,int second)
    {
        if (hour >= 0 && hour<= 23)
        {
            if (minute >= 0 && minute <= 59)
            {
                if (second >= 0 && second <= 59)
                {
                    this.hour = hour;
                    this.minute = minute;
                    this.second = second;
                }
            }
        }
    }

    public String toString()
    {
        if (hour < 10)
        {
            if (minute < 10)
            {
                if (second < 10)
                {
                    return "0" + hour + ":0" + minute + ":0" + second;
                }

                else
                {
                    return "0" + hour + ":0" + minute + ":" + second;
                }
            }

            else
            {
                if (second < 10)
                {
                    return "0" + hour + ":" + minute + ":0" + second;
                }

                else
                {
                    return "0" + hour + ":" + minute + ":" + second;
                }
            }
        }

        else
        {
            if (minute < 10)
            {
                if (second < 10)
                {
                    return hour + ":0" + minute + ":0" + second;
                }

                else
                {
                    return hour + ":0" + minute + ":" + second;
                }
            }

            else
            {
                if (second < 10)
                {
                    return hour + ":" + minute + ":0" + second;
                }

                else
                {
                    return hour + ":" + minute + ":" + second;
                }
            }
        }
    }

    public time nextSecond()
    {
        second += 1;
        if (second > 59)
        {
            second = 0;
            minute += 1;
            if(minute > 59)
            {
                minute = 0;
                hour += 1;
                if (hour > 23)
                {
                    hour = 0;
                }
            }
        }

        return this;
    }

    public time previousSecond()
    {
        second -= 1;
        if(second == -1)
        {
            second = 59;
            minute -= 1;
            if (minute == -1)
            {
                minute = 59;
                hour -= 1;
                if (hour == -1)
                {
                    hour = 23;
                }
            }
        }

        return this;
    }
};