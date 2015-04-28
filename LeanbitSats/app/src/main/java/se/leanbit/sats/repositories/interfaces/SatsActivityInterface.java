package se.leanbit.sats.repositories.interfaces;


import se.leanbit.sats.models.SatsActivity;

public interface SatsActivityInterface
{
    String getActivityName(SatsActivity activity);
    String getRegion(SatsActivity activity);
    Boolean isCustom(SatsActivity activity);
    int que(SatsActivity activity);
    int duration(SatsActivity activity);
    Boolean isCompleted(SatsActivity activity);
    String instructor(SatsActivity activity);
    String startTimeHm(SatsActivity activity);
    String getDate(SatsActivity activity); //"Torsdag 25/4"
    String getDateHeaderToday(SatsActivity activity);// ( Idag, Måndag 20/4 )
    String getDateHeaderOtherWeek(SatsActivity activity); //( Vecka 14 (30/3-5/4) )
    Boolean comments(SatsActivity activity);
    int getWeek(SatsActivity activity);
    Boolean isPast(SatsActivity activity);
}
