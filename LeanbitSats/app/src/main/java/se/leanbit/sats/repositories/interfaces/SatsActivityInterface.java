package se.leanbit.sats.repositories.interfaces;


import java.util.LinkedHashMap;

import se.leanbit.sats.models.SatsActivity;

public interface SatsActivityInterface
{
    String getActivityName(final SatsActivity activity);
    String getGroupType(final SatsActivity activity);
    String getRegion(final SatsActivity activity);
    Boolean isCustom(final SatsActivity activity);
    int que(final SatsActivity activity);
    int duration(final SatsActivity activity);
    Boolean isCompleted(final SatsActivity activity);
    String instructor(final SatsActivity activity);
    String startTimeHm(final SatsActivity activity);
    Boolean comments(final SatsActivity activity);
    Boolean isPast(final SatsActivity activity);
    public int getMaxTraning(final SatsActivity activity[]);
    public LinkedHashMap<String, Integer> getTraningMap(final SatsActivity activity[]);
}
