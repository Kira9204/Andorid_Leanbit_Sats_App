package se.leanbit.sats.repositories.interfaces;

import se.leanbit.sats.models.SatsActivity;

public interface SatsTimeFormatInterface
{
    //Example: 3 April
    public String getDate(SatsActivity activity);
    //Example: fredag
    public String getDayName(SatsActivity activity);
    //Return an array with hours and minutes as separate strings
    public String[] getHoursMinutes(SatsActivity activity);
    //Example: 25 - 31/1
    public String getWeekDates(SatsActivity activity);
    //Example 1
    public int getWeekNum(SatsActivity activity);
}
