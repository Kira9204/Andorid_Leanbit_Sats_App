package se.segr.android.leanbit_sats_app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Activities implements ActivityInterface
{

	public Activity[] activities;
	public String url;
	public String userId;
	
	public void populateActivitiesBetwineen(String fromDate, String toDate){


        WebRequest rec = new WebRequest();
        try {

            rec.execute("http://leanbit.erikwelander.se/api.sats.com/v1.0/se/training/activities/"+ fromDate + "/" + toDate).get();
            Gson gson = new GsonBuilder().create();
            Activities activitieReq = gson.fromJson(rec.result, Activities.class);
            this.url = activitieReq.url;
            this.userId = activitieReq.userId;
            this.activities = activitieReq.activities;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
	public String getActivityName(Activity activity)
	{
		return activity.subType;
	}
	public String getRegion(Activity activity)
	{

        WebRequest rec = new WebRequest();
        try {

            rec.execute("https://api2.sats.com/v1.0/se/centers/" + activity.booking.centerId).get();
            Gson gson = new GsonBuilder().create();
            Center center = gson.fromJson(rec.result, Center.class);

            return center.center.name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //return null;//have to make another api req
	return null;
    }
	public Boolean isCustom(Activity activity)
	{
		return activity.source.equalsIgnoreCase("SATS");
	}
	public int que(Activity activity)
	{
		return activity.booking.positionInQueue;
	}
	public int duration(Activity activity)
	{
		return activity.durationInMinutes;
	}
	public Boolean isCompleted(Activity activity)
	{
		return activity.status.equalsIgnoreCase("COMPLETED");
	}
	public String instructor(Activity activity)
	{
		return activity.booking.clazz.instructorId;
	}
	public String startTimeHm(Activity activity)
	{
		return activity.booking.clazz.startTime;
	}
	public String getDate(Activity activity)
	{   //"Torsdag 25/4"
        String dateTime = activity.date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf.parse(dateTime);
            StringBuilder builder = new StringBuilder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String weekDay = findWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
            builder.append(weekDay);
            builder.append(" " + date.getDate() + "/" + (date.getMonth() + 1));
            return builder.toString();


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
	}
	public String getDateHeaderToday(Activity activity)
	{
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

	public String getDateHeaderOtherWeek(Activity activity) {
        //Vecka 14 (30/3-5/4)
        String dateTime = activity.date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf.parse(dateTime);
            StringBuilder builder = new StringBuilder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

            String weekDay = findWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
            builder.append(weekOfYear);
            builder.append(" " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "-");

            calendar.roll(Calendar.DAY_OF_YEAR, 8);
            builder.append(" " + calendar.get(Calendar.DAY_OF_WEEK) + "/" + (calendar.get(Calendar.MONTH) + 1));
            return builder.toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }

	public Boolean comments(Activity activity)
	{
        if(activity.comment.length() == 0){
            return true;
        }
		return false;
	}

    public int getWeek(Activity activity) {

        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        try {
            date = sdf.parse(activity.date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    @Override
    public Boolean isPast(Activity activity) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        try {
            date = sdf.parse(activity.date);
            if(date.before(date = new Date())){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String findWeekDay(int weekNumb){

        String weekDay;
        switch(weekNumb){
            case 1: weekNumb = 0;
                weekDay = "Sunday";
                break;

            case 2: weekNumb = 1;
                weekDay = "Monday";
                break;

            case 3: weekNumb = 2;
                weekDay = "Tuesday";
                break;

            case 4: weekNumb = 3;
                weekDay = "wednesday";
                break;

            case 5: weekNumb = 4;
                weekDay = "thursday";
                break;

            case 6: weekNumb = 5;
                weekDay = "friday";
                break;

            case 7: weekNumb = 6;
                weekDay = "saturday";
                break;
            default: weekDay = null;
                break;
        }
        return weekDay;
    };
	
	
}
