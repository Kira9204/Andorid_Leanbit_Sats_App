package se.leanbit.sats.repositories.services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import se.leanbit.sats.models.SatsActivities;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.models.SatsCenters;
import se.leanbit.sats.repositories.interfaces.SatsActivityInterface;

public class SatsActivitiesService implements SatsActivityInterface
{

    public SatsActivity[] getActivitiesBetween(final String fromDate, final String toDate)
    {
        WebService webService = new WebService();
        final String url = "http://leanbit.erikwelander.se/api.sats.com/v1.0/se/training/activities/";
        String jsonResponse = "";
        try
        {
            jsonResponse = webService.execute(url + "/" + fromDate + "/" + toDate).get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        SatsActivities satsActivities = gson.fromJson(jsonResponse, SatsActivities.class);

        return satsActivities.activities;
    }

    @Override
    public String getActivityName(SatsActivity activity)
    {
        return activity.subType;
    }

    @Override
    public String getRegion(SatsActivity activity)
    {
        WebService webService = new WebService();
        final String url = "https://api2.sats.com/v1.0/se/centers/";

        String jsonResponse = "";
        try
        {
            jsonResponse = webService.execute(url + activity.booking.centerId).get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        SatsCenters satsCenters = gson.fromJson(jsonResponse, SatsCenters.class);

        return satsCenters.center.name;
    }

    @Override
    public Boolean isCustom(SatsActivity activity)
    {
        return !activity.source.equalsIgnoreCase("SATS");
    }

    @Override
    public int que(SatsActivity activity)
    {
        return activity.booking.positionInQueue;
    }

    @Override
    public int duration(SatsActivity activity)
    {
        return activity.durationInMinutes;
    }

    @Override
    public Boolean isCompleted(SatsActivity activity)
    {
        return activity.status.equalsIgnoreCase("COMPLETED");
    }

    @Override
    public String instructor(SatsActivity activity)
    {
        return activity.booking.clazz.instructorId;
    }

    @Override
    public String startTimeHm(SatsActivity activity)
    {
        return activity.booking.clazz.startTime;
    }

    @Override
    public String getDate(SatsActivity activity)
    {
        //"Torsdag 25/4"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date activityDate = new Date();
        try
        {
            activityDate = dateFormat.parse(activity.date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(activityDate);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(findWeekDay(calendar.get(Calendar.DAY_OF_WEEK))+" ")+;
        stringBuilder.append(calendar.get(Calendar.DATE) + "/");
        stringBuilder.append(calendar.get(Calendar.MONTH) +1);
        return stringBuilder.toString();

    }

    @Override
    public String getDateHeaderToday(SatsActivity activity)
    {
        //( Idag, Måndag 20/4 )
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date activityDate = new Date();
        try
        {
            activityDate = dateFormat.parse(activity.date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(activityDate);




        String dateTime = activity.date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf.parse(dateTime);
            Calendar calendatOfToday = Calendar.getInstance();
            Date newDate = new Date();
            calendatOfToday.setTime(newDate);
            StringBuilder builder = new StringBuilder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            if(calendar.get(Calendar.DAY_OF_MONTH) == calendatOfToday.get(Calendar.DAY_OF_MONTH)
                    && calendar.get(Calendar.MONTH) == calendatOfToday.get(Calendar.MONTH)
                    && calendar.get(Calendar.YEAR) == calendatOfToday.get(Calendar.YEAR)){
                String weekDay = findWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
                builder.append("Today ");
                builder.append(weekDay);
                builder.append(" " + date.getDate() + "/" + (date.getMonth() + 1));
                return builder.toString();
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public String getDateHeaderOtherWeek(SatsActivity activity) {
        return null;
    }

    @Override
    public Boolean comments(SatsActivity activity) {
        return null;
    }

    @Override
    public int getWeek(SatsActivity activity) {
        return 0;
    }

    @Override
    public Boolean isPast(SatsActivity activity) {
        return null;
    }

    private String findWeekDay(int weekNumb)
    {
        String weekDay;
        switch(weekNumb){
            case 1:
                weekNumb = 0;
                weekDay = "Sunday";
                break;

            case 2:
                weekNumb = 1;
                weekDay = "Monday";
                break;

            case 3:
                weekNumb = 2;
                weekDay = "Tuesday";
                break;

            case 4:
                weekNumb = 3;
                weekDay = "wednesday";
                break;

            case 5:
                weekNumb = 4;
                weekDay = "thursday";
                break;

            case 6:
                weekNumb = 5;
                weekDay = "friday";
                break;

            case 7:
                weekNumb = 6;
                weekDay = "saturday";
                break;
            default:
                weekDay = "";
                break;
        }
        return weekDay;
    }
}
