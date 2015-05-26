package se.leanbit.sats.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sebastiangraveleij on 26/05/15.
 */
public class SatsFullCenters
{
    public Boolean availableForOnlineBooking;
    public String description;
    public String filterId;
    public String id;
    public Boolean isElixia;
    public double lat;
    @SerializedName("long")
    public double lon;
    public String name;
    public String regionId;
    public String url;
}
