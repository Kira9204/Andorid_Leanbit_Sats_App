package se.leanbit.sats.repositories.services;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

import se.leanbit.sats.models.SatsActivities;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.models.SatsCenter;
import se.leanbit.sats.models.SatsCenters;
import se.leanbit.sats.repositories.interfaces.SatsActivityInterface;

public class SatsActivitiesService implements SatsActivityInterface
{
    private static HashMap<String, String> centerMap = new HashMap<>();

    public SatsActivity[] getActivitiesBetween(final String fromDate, final String toDate)
    {
        WebService webService = new WebService();
        final String url = "http://leanbit.erikwelander.se/api.sats.com/v1.0/se/training/activities";
        String jsonResponse = "";
        try
        {
            jsonResponse = webService.execute(url + "/" + fromDate + "/" + toDate).get();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        activitiesParser activitiesParser = new activitiesParser();
        SatsActivities satsActivities = new SatsActivities();
        try
        {

            satsActivities = activitiesParser.execute(jsonResponse).get();

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

        for (SatsActivity act : satsActivities.activities)
        {
            getRegion(act);
        }

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
        if (null != activity.booking)
        {
        if (centerMap.containsKey(activity.booking.centerId))
        {
            return centerMap.get(activity.booking.centerId);
        }
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

            centerParser centerParser = new centerParser();
            try
            {

                SatsCenters satsCenters = centerParser.execute(jsonResponse).get();
                if (null != satsCenters)
                {
                    centerMap.put(activity.booking.centerId, satsCenters.center.name);
                    return satsCenters.center.name;
                }

                return "";
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } catch (ExecutionException e)
            {
                e.printStackTrace();
            }
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
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return (new Date().after(activityDate));
    }

    public LinkedHashMap<String, Integer> getTraningMap(final SatsActivity activity[])
    {
        SatsTimeFormatService satsTimeFormatService = new SatsTimeFormatService();
        LinkedHashMap<String, Integer> traningMap = new LinkedHashMap<>();
        for (int i = 0; i < activity.length; i++)
        {

            if (traningMap.containsKey(satsTimeFormatService.getWeekDates(activity[i])))
            {
                int currentTraningNum = traningMap.get(satsTimeFormatService.getWeekDates(activity[i]));
                currentTraningNum = currentTraningNum + 1;
                traningMap.put(satsTimeFormatService.getWeekDates(activity[i]), currentTraningNum);
            } else
            {
                traningMap.put(satsTimeFormatService.getWeekDates(activity[i]), 1);
            }

        }
        return traningMap;
    }

    public int getMaxTraning(final SatsActivity activity[])
    {
        LinkedHashMap<String, Integer> traningMap = new LinkedHashMap<>();
        traningMap = getTraningMap(activity);

        int topTraningCount = 0;
        for (Integer value : traningMap.values())
        {
            if (topTraningCount < value)
            {
                topTraningCount = value;
            }
        }

        return topTraningCount;
    }

    private class activitiesParser extends AsyncTask<String, String, SatsActivities>
    {

        @Override
        protected SatsActivities doInBackground(String... params)
        {
            Gson gson = new GsonBuilder().create();
            SatsActivities satsActivities = gson.fromJson(params[0], SatsActivities.class);
            return satsActivities;
        }
    }

    private class centerParser extends AsyncTask<String, String, SatsCenters>
    {

        @Override
        protected SatsCenters doInBackground(String... params)
        {
            Gson gson = new GsonBuilder().create();
            SatsCenters satsCenters = gson.fromJson(params[0], SatsCenters.class);
            return satsCenters;
        }
    }
}

