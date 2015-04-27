package se.segr.android.leanbit_sats_app;

public interface ActivityInterface {

    String getActivityName(Activity activity);
    String getRegion(Activity activity);
    Boolean isCustom(Activity activity);
    int que(Activity activity);
    int duration(Activity activity);
    Boolean isCompleted(Activity activity);
    String instructor(Activity activity);
    String startTimeHm(Activity activity);
    String getDate(Activity activity); //"Torsdag 25/4"
    String getDateHeaderToday(Activity activity);// ( Idag, Måndag 20/4 )
    String getDateHeaderOtherWeek(Activity activity); //( Vecka 14 (30/3-5/4) )
    Boolean comments(Activity activity);
    int getWeek(Activity activity);
    Boolean isPast(Activity activity);

}