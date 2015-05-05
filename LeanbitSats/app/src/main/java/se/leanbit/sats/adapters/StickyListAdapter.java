package se.leanbit.sats.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.leanbit.sats.R;
import se.leanbit.sats.models.SatsActivity;
import se.leanbit.sats.repositories.services.SatsActivitiesService;
import se.leanbit.sats.repositories.services.SatsTimeFormatService;

/**
 * Created by gina on 2015-04-22.
 */
public class StickyListAdapter extends BaseAdapter implements StickyListHeadersAdapter
{

    private static final int PAST_ACTIVITY = 0;
    private static final int CUSTOM_ACTIVITY = 1;
    private static final int SATS_ACTIVITY = 2;
    private LayoutInflater inflater;
    private SatsActivitiesService satsActivitiesService;
    private SatsTimeFormatService satsTimeFormatService;
    private ArrayList<SatsActivity> mActivityList;


    public StickyListAdapter(Context context, ArrayList<SatsActivity> list)
    {
        inflater = LayoutInflater.from(context);
        this.mActivityList = list;
        satsActivitiesService = new SatsActivitiesService();
        satsTimeFormatService = new SatsTimeFormatService();
    }

    @Override
    public long getHeaderId(int i)
    {
        if (satsActivitiesService.isPast(mActivityList.get(i)))
        {
            return satsTimeFormatService.getWeekNum(mActivityList.get(i));
        }
        return i;
    }

    @Override
    public int getCount()
    {
        return mActivityList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mActivityList.indexOf(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolderPast pastHolder;
        ViewHolderFuture futureHolder;
        ViewHolderCustom customHolder;


        if (getItemViewType(position) == PAST_ACTIVITY)
        {

            if (convertView == null)
            {
                pastHolder = new ViewHolderPast();
                convertView = inflater.inflate(R.layout.past_activity, parent, false);
                pastHolder.textName = (TextView) convertView.findViewById(R.id.past_activity_name);
                pastHolder.textDate = (TextView) convertView.findViewById(R.id.past_activity_date);
                pastHolder.textComment = (TextView) convertView.findViewById(R.id.past_activity_comment);
                pastHolder.textCompleted = (TextView) convertView.findViewById(R.id.past_activity_completed);
                pastHolder.imageCheck = (ImageView) convertView.findViewById(R.id.image_checkbox);
                pastHolder.imageMan = (ImageView) convertView.findViewById(R.id.image_man);
                pastHolder = setHolderText(pastHolder, position);
                convertView.setTag(pastHolder);
                Log.d("past", "getView fired ..............");

            } else
            {

                pastHolder = (ViewHolderPast) convertView.getTag();
                pastHolder = setHolderText(pastHolder, position);
                convertView.setTag(pastHolder);
                Log.d("past", "getView fired ..............");
            }
            return convertView;

        } else
        {

            if (getItemViewType(position) == CUSTOM_ACTIVITY)
            {
                if (convertView == null)
                {
                    customHolder = new ViewHolderCustom();
                    convertView = inflater.inflate(R.layout.custom_activity, parent, false);
                    customHolder.textName = (TextView) convertView.findViewById(R.id.custom_activity_name);
                    customHolder.textDuration = (TextView) convertView.findViewById(R.id.custom_activity_duration);
                    customHolder.textComment = (TextView) convertView.findViewById(R.id.custom_activity_comment);
                    customHolder.buttonDetails = (Button) convertView.findViewById(R.id.custom_activity_button);
                    customHolder.textCalendar = (TextView) convertView.findViewById(R.id.custom_activity_calendar);
                    customHolder.textTrainingProgram = (TextView) convertView.findViewById((R.id.custom_activity_training_program));
                    convertView.setTag(customHolder);
                    customHolder = setCustomHolderText(customHolder, position);

                } else
                {
                    customHolder = (ViewHolderCustom) convertView.getTag();
                    customHolder = setCustomHolderText(customHolder, position);
                }
                return convertView;
            } else
            {
                if (convertView == null)
                {
                    futureHolder = new ViewHolderFuture();
                    convertView = inflater.inflate(R.layout.future_activity, parent, false);
                    futureHolder.textName = (TextView) convertView.findViewById(R.id.future_activity_name);
                    futureHolder.textInstructor = (TextView) convertView.findViewById(R.id.future_activity_instructor);
                    futureHolder.textRegion = (TextView) convertView.findViewById(R.id.future_activity_region);
                    futureHolder.textDuration = (TextView) convertView.findViewById(R.id.future_activity_duration);
                    futureHolder.textQue = (TextView) convertView.findViewById(R.id.future_activity_que);
                    futureHolder.textCalendar = (TextView) convertView.findViewById(R.id.future_activity_Calendar);
                    futureHolder.textPass = (TextView) convertView.findViewById(R.id.future_activity_pass);
                    futureHolder.buttonCancel = (Button) convertView.findViewById(R.id.future_activity_cancel);
                    futureHolder.textHour = (TextView) convertView.findViewById(R.id.future_activity_hour);
                    futureHolder.textMinutes = (TextView) convertView.findViewById(R.id.future_activity_minutes);
                    futureHolder.imageQue = (ImageButton) convertView.findViewById(R.id.image_que);
                    convertView.setTag(futureHolder);
                    futureHolder = setFutureViewHolder(futureHolder, position);

                } else
                {
                    futureHolder = (ViewHolderFuture) convertView.getTag();
                    futureHolder = setFutureViewHolder(futureHolder, position);
                }
                return convertView;
            }
        }
    }

    private ViewHolderFuture setFutureViewHolder(ViewHolderFuture futureHolder, int position)
    {
        futureHolder.textName.setText(satsActivitiesService.getActivityName(mActivityList.get(position)));
        futureHolder.textInstructor.setText(satsActivitiesService.instructor(mActivityList.get(position)));
        futureHolder.textRegion.setText(satsActivitiesService.getRegion(mActivityList.get(position)));
        futureHolder.textDuration.setText("" + satsActivitiesService.duration(mActivityList.get(position)) + " min");
        int queCounter = satsActivitiesService.que(mActivityList.get(position));
        if(queCounter == 0){
        futureHolder.textQue.setText("");
        futureHolder.imageQue.setImageResource(R.drawable.done_2_icon);
        }else{
            futureHolder.textQue.setText(""+ queCounter);

        }



        futureHolder.textCalendar.setText("Lägg till i kalender");
        futureHolder.textPass.setText("Mer om passet");
        futureHolder.buttonCancel.setText("Avboka");
        futureHolder.textHour.setText(satsTimeFormatService.getHoursMinutes(mActivityList.get(position))[0]);
        futureHolder.textMinutes.setText(satsTimeFormatService.getHoursMinutes(mActivityList.get(position))[1]);
        return futureHolder;
    }

    private ViewHolderCustom setCustomHolderText(ViewHolderCustom customHolder, int position)
    {
        customHolder.textName.setText(satsActivitiesService.getActivityName(mActivityList.get(position)));
        customHolder.textDuration.setText(satsActivitiesService.duration(mActivityList.get(position)) + " min");
        customHolder.buttonDetails.setText("Detaljer");
        customHolder.textCalendar.setText("Lägg till i kalender");
        customHolder.textTrainingProgram.setText("Träningsprogram");
        if (satsActivitiesService.comments(mActivityList.get(position)))
        {
            customHolder.textComment.setText("1 kommentar");
        } else
        {
            customHolder.textComment.setText("Lägg till kommentar");
        }
        return customHolder;
    }

    private ViewHolderPast setHolderText(ViewHolderPast pastHolder, int position)
    {
        String activityName = satsActivitiesService.getActivityName(mActivityList.get(position));
        String activityTypeGroup = satsActivitiesService.getGroupType(mActivityList.get(position));

        pastHolder.textName.setText(activityName);
        pastHolder.textDate.setText(satsTimeFormatService.getDayName(mActivityList.get(position)) + " " + satsTimeFormatService.getDate(mActivityList.get(position)));
        switch (activityTypeGroup){
            case "GROUP": pastHolder = setPictureOfGroup(activityName, pastHolder);

                break;
            case "GYM": pastHolder = setPictureOfGym(activityName, pastHolder);

                break;
            case "OTHER": pastHolder = setPictureOfOther(activityName, pastHolder);

                break;
            default: pastHolder.imageMan.setImageResource(R.drawable.all_training_icons);
        }
        if (satsActivitiesService.comments(mActivityList.get(position)))
        {

            pastHolder.textComment.setText("1 kommentar");

        } else
        {

            pastHolder.textComment.setText("Lägg till kommentar");
        }
        if (satsActivitiesService.isCompleted(mActivityList.get(position)))
        {
            pastHolder.textCompleted.setText("Avklarat!");
            pastHolder.imageCheck.setImageResource(R.drawable.checkmark_icon);

        } else
        {
            pastHolder.textCompleted.setText("Avklarat?");
            pastHolder.imageCheck.setImageResource(R.drawable.checkmark_button_normal);
        }
        return pastHolder;
    }
    private ViewHolderPast setPictureOfOther(String activityName, ViewHolderPast pastHolder) {

        if(activityName.equals("walking")){
            pastHolder.imageMan.setImageResource(R.drawable.running_icon);
        }else if (activityName.equals("football")){
            pastHolder.imageMan.setImageResource(R.drawable.all_training_icons);
        }else if(activityName.equals("cycle")){
            pastHolder.imageMan.setImageResource(R.drawable.cykling_icon);
        }else{
            pastHolder.imageMan.setImageResource(R.drawable.all_training_icons);
        }
        return pastHolder;
    }

    private ViewHolderPast setPictureOfGym(String activityName, ViewHolderPast pastHolder) {
        pastHolder.imageMan.setImageResource(R.drawable.all_training_icons);
        return pastHolder;
    }

    private ViewHolderPast setPictureOfGroup(String activityName , ViewHolderPast pastHolder) {
        if(activityName.equals("SatsCycling")|| activityName.equals("Easy Cycling")|| activityName.equals("Cycling Pulse" )){
            pastHolder.imageMan.setImageResource(R.drawable.cykling_icon);
        }else if(activityName.equals("shape") ){
            pastHolder.imageMan.setImageResource(R.drawable.strength_trainging_icon);
        }else if (activityName.equals("GROUP")){
            pastHolder.imageMan.setImageResource(R.drawable.group_training_icon);
        }else {
            pastHolder.imageMan.setImageResource(R.drawable.all_training_icons);
        }

        return pastHolder;
    }


    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent)
    {
        HeaderViewHolder holder;
        String headerText;

        if (convertView == null)
        {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.header_view, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text_header);



            convertView.setTag(holder);
        } else
        {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        if(satsActivitiesService.isPast(mActivityList.get(position))){
            headerText = "Vecka " + satsTimeFormatService.getWeekNum(mActivityList.get(position)) + " ( " + satsTimeFormatService.getWeekDates(mActivityList.get(position)) + " ) ";
        }else {
            if(satsTimeFormatService.isToday(mActivityList.get(position))){
                headerText = "Idag, " + satsTimeFormatService.getDayName(mActivityList.get(position)) + "  " + satsTimeFormatService.getDate(mActivityList.get(position));
            }
            else {
                headerText = satsTimeFormatService.getDayName(mActivityList.get(position)) + "  " + satsTimeFormatService.getDate(mActivityList.get(position));
            }
        }
        holder.text.setText(headerText);

        return convertView;
    }

    public int getItemViewType(int position)
    {

        if (satsActivitiesService.isPast(mActivityList.get(position)) == true)
        {
            return PAST_ACTIVITY;
        } else
        {
            if ((satsActivitiesService.isCustom(mActivityList.get(position)) == true))
            {
                return CUSTOM_ACTIVITY;
            } else
            {
                return SATS_ACTIVITY;
            }

        }
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    class ViewHolderFuture
    {
        TextView textName;
        TextView textInstructor;
        TextView textRegion;
        TextView textDuration;
        TextView textQue;
        ImageButton imageQue;
        TextView textCalendar;
        TextView textPass;
        Button buttonCancel;
        TextView textHour;
        TextView textMinutes;
    }

    class ViewHolderCustom
    {
        TextView textName;
        TextView textDuration;
        Button buttonDetails;
        TextView textComment;
        TextView textCalendar;
        TextView textTrainingProgram;
    }

    class HeaderViewHolder
    {
        TextView text;
    }

    class ViewHolderPast
    {
        TextView textName;
        TextView textDate;
        TextView textComment;
        TextView textCompleted;
        ImageView imageMan;
        ImageView imageCheck;
    }


}