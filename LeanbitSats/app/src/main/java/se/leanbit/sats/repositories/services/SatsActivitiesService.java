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
        final String url = "http://leanbit.erikwelander.se/api.sats.com/v1.0/se/training/activities";
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
    public String getActivityName(final SatsActivity activity)
    {
        return activity.subType;
    }

    @Override
    public String getGroupType(final SatsActivity activity)
    {
       return activity.type;
    }


    @Override
    public String getRegion(final SatsActivity activity)
    {
        final SatsActivity.SatsBooking booking = activity.booking;
        if(null != activity.booking)
        {
            WebService webService = new WebService();
            final String url = "https://api2.sats.com/v1.0/se/centers/";

            String jsonResponse = "";
            try
            {
                jsonResponse = webService.execute(url + activity.booking.centerId).get();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            Gson gson = new GsonBuilder().create();
            SatsCenters satsCenters = gson.fromJson(jsonResponse, SatsCenters.class);
            if(null != satsCenters)
            {
                return satsCenters.center.name;
            }
            return "";
        }
        return "";
    }

    @Override
    public Boolean isCustom(final SatsActivity activity)
    {
        return null == activity.booking;
    }

    @Override
    public int que(final SatsActivity activity)
    {
        return activity.booking.positionInQueue;
    }

    @Override
    public int duration(final SatsActivity activity)
    {
        return activity.durationInMinutes;
    }

    @Override
    public Boolean isCompleted(final SatsActivity activity)
    {
        return activity.status.equalsIgnoreCase("COMPLETED");
    }

    @Override
    public String instructor(final SatsActivity activity)
    {
        return activity.booking.clazz.instructorId;
    }

    @Override
    public String startTimeHm(final SatsActivity activity)
    {
        return activity.booking.clazz.startTime;
    }
    @Override
    public Boolean comments(final SatsActivity activity)
    {
        return activity.comment.length() > 0;
    }

    @Override
    public Boolean isPast(final SatsActivity activity)
    {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date activityDate = new Date();
        try
        {
            activityDate = dateFormat.parse(activity.date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return (new Date().after(activityDate));
    }
}
