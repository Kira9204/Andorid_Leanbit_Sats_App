package se.leanbit.sats.repositories.interfaces;


import se.leanbit.sats.models.SatsActivity;

public interface SatsActivityInterface
{
    String getActivityName(SatsActivity activity);
    String getGroupType(SatsActivity activity);
    String getRegion(SatsActivity activity);
    Boolean isCustom(SatsActivity activity);
    int que(SatsActivity activity);
    int duration(SatsActivity activity);
    Boolean isCompleted(SatsActivity activity);
    String instructor(SatsActivity activity);
    String startTimeHm(SatsActivity activity);
    Boolean comments(SatsActivity activity);
    Boolean isPast(SatsActivity activity);
}
