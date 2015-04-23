package BookedModdel;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonTest
{
	
	public static void main(String[] args){
		
        String jsonString = "[{\n" +
                "\t\"booking\": {\n" +
                "\t\"centerId\": \"567\",\n" +
                "\t\"clazz\": {\n" +
                "\t\"bookedPersonsCount\": 39,\n" +
                "\t\"centerFilterId\": \"567\",\n" +
                "\t\"classCategoryIds\": [\"5\"],\n" +
                "\t\"classTypeId\": \"346\",\n" +
                "\t\"durationInMinutes\": 60,\n" +
                "\t\"id\": \"567p31447\",\n" +
                "\t\"instructorId\": \"Sofia Strindö\",\n" +
                "\t\"maxPersonsCount\": 40,\n" +
                "\t\"name\": \"Shape\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"startTime\": \"2015-04-20T11:00:00+02:00\",\n" +
                "\t\"waitingListCount\": 0\n" +
                "\t},\n" +
                "\t\"id\": \"567p824512\",\n" +
                "\t\"positionInQueue\": 0,\n" +
                "\t\"status\": \"confirmed\"\n" +
                "\t},\n" +
                "\t\"comment\": \"\",\n" +
                "\t\"date\": \"2015-04-20T11:00:00+02:00\",\n" +
                "\t\"distanceInKm\": 0,\n" +
                "\t\"durationInMinutes\": 60,\n" +
                "\t\"id\": \"b.567p824512\",\n" +
                "\t\"source\": \"SATS\",\n" +
                "\t\"status\": \"PLANNED\",\n" +
                "\t\"subType\": \"Shape\",\n" +
                "\t\"type\": \"GROUP\"\n" +
                "\t},{\n" +
                "\t\"booking\": {\n" +
                "\t\"centerId\": \"666\",\n" +
                "\t\"clazz\": {\n" +
                "\t\"bookedPersonsCount\": 39,\n" +
                "\t\"centerFilterId\": \"567\",\n" +
                "\t\"classCategoryIds\": [\"5\"],\n" +
                "\t\"classTypeId\": \"346\",\n" +
                "\t\"durationInMinutes\": 60,\n" +
                "\t\"id\": \"567p31447\",\n" +
                "\t\"instructorId\": \"Sofia Strindö\",\n" +
                "\t\"maxPersonsCount\": 40,\n" +
                "\t\"name\": \"Shape\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"startTime\": \"2015-04-20T11:00:00+02:00\",\n" +
                "\t\"waitingListCount\": 0\n" +
                "\t},\n" +
                "\t\"id\": \"567p824512\",\n" +
                "\t\"positionInQueue\": 0,\n" +
                "\t\"status\": \"confirmed\"\n" +
                "\t},\n" +
                "\t\"comment\": \"\",\n" +
                "\t\"date\": \"2015-04-20T11:00:00+02:00\",\n" +
                "\t\"distanceInKm\": 0,\n" +
                "\t\"durationInMinutes\": 60,\n" +
                "\t\"id\": \"b.567p824512\",\n" +
                "\t\"source\": \"SATS\",\n" +
                "\t\"status\": \"PLANNED\",\n" +
                "\t\"subType\": \"Shape\",\n" +
                "\t\"type\": \"GROUP\"\n" +
                "\t}]";
        activities[] acts;
        Gson gson = new GsonBuilder().create();
        acts = gson.fromJson(jsonString, activities[].class);
        int inni = 0;
        if(inni == 1){
        	
        };
	}

}
