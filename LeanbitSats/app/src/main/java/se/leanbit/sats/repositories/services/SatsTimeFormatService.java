package se.leanbit.sats.repositories.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.interfaces.SatsTimeFormatInterface;

/**
 * Created by erik on 2015-04-28.
 */
public class SatsTimeFormatService implements SatsTimeFormatInterface
{
    private final String months[] = {"Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli", "Augusti", "September" ,"Oktober", "November", "Decemober"};
    private final String weekDays[] = {"Söndag", "Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag"};
    @Override
    public String getDate(SatsActivity activity)
    {
        Calendar activityDate = getDateCalendar(activity.date);
        int currentDate = activityDate.get(Calendar.DATE);
        String currentMonth = months[activityDate.get(Calendar.MONTH)];
        return ""+currentDate+" "+currentMonth;
    }

    @Override
    public String getDayName(SatsActivity activity)
    {
        Calendar activityDate = getDateCalendar(activity.date);
        return weekDays[activityDate.get(activityDate.DAY_OF_WEEK)];
    }

    @Override
    public String[] getHoursMinutes(SatsActivity activity)
    {
        String split[] = activity.date.split(" ");
        String timeSplit[] = split[1].split(":");

        String returnStr[] = new String[2];
        returnStr[0] = timeSplit[0];
        returnStr[1] = timeSplit[1];
        return returnStr;
    }

    @Override
    public String getWeekDates(SatsActivity activity)
    {
        //Vecka 14 (30/3-5/4)
        Calendar activityDate = getDateCalendar(activity.date);
        activityDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        StringBuilder builder = new StringBuilder();
        builder.append(" " + activityDate.get(Calendar.DAY_OF_MONTH) + " -");
        activityDate.roll(Calendar.DAY_OF_YEAR, 6);
        builder.append(" " + activityDate.get(Calendar.DAY_OF_MONTH) + "/" + (activityDate.get(Calendar.MONTH) + 1));
        return builder.toString();
    }

    @Override
    public int getWeekNum(SatsActivity activity)
    {
        Calendar activityDate = getDateCalendar(activity.date);
        return activityDate.get(activityDate.WEEK_OF_YEAR);
    }

    private Calendar getDateCalendar(String date)
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date activityDate = new Date();
        try
        {
            activityDate = dateFormat.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(activityDate);
        return calendar;
    }
}
