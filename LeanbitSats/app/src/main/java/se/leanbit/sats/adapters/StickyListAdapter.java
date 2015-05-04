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

        ViewHolder holder;
        ViewHolderFuture futureHolder;
        ViewHolderCustom customHolder;


        if (getItemViewType(position) == PAST_ACTIVITY)
        {

            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.past_activity, parent, false);
                holder.textName = (TextView) convertView.findViewById(R.id.past_activity_name);
                holder.textDate = (TextView) convertView.findViewById(R.id.past_activity_date);
                holder.textComment = (TextView) convertView.findViewById(R.id.past_activity_comment);
                holder.textCompleted = (TextView) convertView.findViewById(R.id.past_activity_completed);
                holder.imageCheck = (ImageView) convertView.findViewById(R.id.image_checkbox);
                holder.imageMan = (ImageView) convertView.findViewById(R.id.image_man);
                holder = setHolderText(holder, position);
                convertView.setTag(holder);
                Log.d("past", "getView fired ..............");

            }
            else
            {

                holder = (ViewHolder) convertView.getTag();
                holder = setHolderText(holder, position);
                convertView.setTag(holder);
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
        futureHolder.textQue.setText("" + satsActivitiesService.que(mActivityList.get(position)));
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

    private ViewHolder setHolderText(ViewHolder holder, int position)
    {
        String activityName = satsActivitiesService.getActivityName(mActivityList.get(position));
        String activityTypeGroup = satsActivitiesService.getGroupType(mActivityList.get(position));

        holder.textName.setText(activityName);
        holder.textDate.setText(satsTimeFormatService.getDayName(mActivityList.get(position)) + " " + satsTimeFormatService.getDate(mActivityList.get(position)));
        switch (activityTypeGroup){
            case "GROUP": holder = setPictureOfGroup(activityName, holder);

                break;
            case "GYM": holder = setPictureOfGym(activityName, holder);

                break;
            case "OTHER": holder = setPictureOfOther(activityName, holder);

                break;
            default: holder.imageMan.setImageResource(R.drawable.all_training_icons);
        }
        if (satsActivitiesService.comments(mActivityList.get(position)))
        {

            holder.textComment.setText("1 kommentar");

        } else
        {

            holder.textComment.setText("Lägg till kommentar");
        }
        if (satsActivitiesService.isCompleted(mActivityList.get(position)))
        {
            holder.textCompleted.setText("Avklarat!");
            holder.imageCheck.setImageResource(R.drawable.checkmark_icon);

        } else
        {
            holder.textCompleted.setText("Avklarat?");
            holder.imageCheck.setImageResource(R.drawable.checkmark_button_normal);
        }
        return holder;
    }
    private ViewHolder setPictureOfOther(String activityName, ViewHolder holder) {
        Log.d(activityName + "cycle", "SET PICTURE fired .............................................");

        if(activityName.equals("walking")){
            holder.imageMan.setImageResource(R.drawable.running_icon);
        }else if (activityName.equals("football")){
            holder.imageMan.setImageResource(R.drawable.all_training_icons);
        }else if(activityName.equals("cycle")){
            Log.d(activityName, "SET CYCLE fired .............................................");
            holder.imageMan.setImageResource(R.drawable.cykling_icon);
        }else{
            holder.imageMan.setImageResource(R.drawable.all_training_icons);
        }
        return holder;
    }

    private ViewHolder setPictureOfGym(String activityName, ViewHolder holder) {
        holder.imageMan.setImageResource(R.drawable.all_training_icons);
        return holder;
    }

    private ViewHolder setPictureOfGroup(String activityName , ViewHolder holder) {
        if(activityName.equals("SatsCycling")|| activityName.equals("Easy Cycling")|| activityName.equals("Cycling Pulse" )){
            holder.imageMan.setImageResource(R.drawable.cykling_icon);
        }else if(activityName.equals("shape") ){
            holder.imageMan.setImageResource(R.drawable.strength_trainging_icon);
        }else if (activityName.equals("GROUP")){
            holder.imageMan.setImageResource(R.drawable.group_training_icon);
        }else {
            holder.imageMan.setImageResource(R.drawable.all_training_icons);
        }

        return holder;
    }


    private void setPastActivity(ViewHolder holder, int position, View convertView, ViewGroup parent)
    {
        convertView = inflater.inflate(R.layout.past_activity, parent, false);
        holder.textName = (TextView) convertView.findViewById(R.id.past_activity_name);
        holder.textDate = (TextView) convertView.findViewById(R.id.past_activity_date);
        holder.textComment = (TextView) convertView.findViewById(R.id.past_activity_comment);
        holder.textCompleted = (TextView) convertView.findViewById(R.id.past_activity_completed);
        holder.imageCheck = (ImageView) convertView.findViewById(R.id.image_checkbox);
        convertView.setTag(holder);
        holder.textName.setText(satsActivitiesService.getActivityName(mActivityList.get(position)));
        holder.textDate.setText(satsTimeFormatService.getDayName(mActivityList.get(position))+" "+satsTimeFormatService.getDate(mActivityList.get(position)));

        if (satsActivitiesService.comments(mActivityList.get(position)))
        {
            holder.textComment.setText(" 1 kommentar");
        } else
        {
            holder.textComment.setText("Lägg till kommentar");
        }
        if (satsActivitiesService.isCompleted(mActivityList.get(position)))
        {
            holder.textCompleted.setText("Avklarat!");
            holder.imageCheck.setImageResource(R.drawable.checkmark_icon);

        } else
        {
            holder.textCompleted.setText("Avklarat?");
        }
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

    class ViewHolder
    {
        TextView textName;
        TextView textDate;
        TextView textComment;
        TextView textCompleted;
        ImageView imageMan;
        ImageView imageCheck;
    }


}