package TypesModdel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TypesTest
{
	public static void main(String[] args){
		
		String JsonString = "{\n" +
                "\t\"url\": \"https:\\/\\/api2.sats.com\\/v1.0\\/se\\/training\\/activities\\/types\",\n" +
                "\t\"userId\": \"\",\n" +
                "\t\"types\": [{\n" +
                "\t\"name\": \"Gruppträning\",\n" +
                "\t\"subType\": \"GROUP\",\n" +
                "\t\"type\": \"GROUP\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Styrketräning\",\n" +
                "\t\"subType\": \"gym\",\n" +
                "\t\"type\": \"GYM\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Badminton\",\n" +
                "\t\"subType\": \"badminton\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Basket\",\n" +
                "\t\"subType\": \"basketball\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Cirkelträning\",\n" +
                "\t\"subType\": \"Circuittraining\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Crosstrainer\",\n" +
                "\t\"subType\": \"crosstrainer\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Cykling\",\n" +
                "\t\"subType\": \"cycle\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Dans\",\n" +
                "\t\"subType\": \"dance\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Fotboll\",\n" +
                "\t\"subType\": \"football\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Golf\",\n" +
                "\t\"subType\": \"golf\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Inlines\",\n" +
                "\t\"subType\": \"inlines\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Innebandy\",\n" +
                "\t\"subType\": \"floorball\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Kajak\",\n" +
                "\t\"subType\": \"kayak\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Kampsport\",\n" +
                "\t\"subType\": \"martialarts\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Klättring\",\n" +
                "\t\"subType\": \"climbing\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Längdskidor\",\n" +
                "\t\"subType\": \"crosscountryskiing\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Löpning\",\n" +
                "\t\"subType\": \"running\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Promenad\",\n" +
                "\t\"subType\": \"walking\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Ridsport\",\n" +
                "\t\"subType\": \"riding\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Rodd\",\n" +
                "\t\"subType\": \"rowing\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Simning\",\n" +
                "\t\"subType\": \"swimming\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Skridskor\",\n" +
                "\t\"subType\": \"skates\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Squash\",\n" +
                "\t\"subType\": \"squash\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Tennis\",\n" +
                "\t\"subType\": \"tennis\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Utförsåkning\",\n" +
                "\t\"subType\": \"downhill\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Volleyboll\",\n" +
                "\t\"subType\": \"volleyball\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Yoga\",\n" +
                "\t\"subType\": \"yoga\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}, {\n" +
                "\t\"name\": \"Övrig träning\",\n" +
                "\t\"subType\": \"other\",\n" +
                "\t\"type\": \"OTHER\"\n" +
                "\t}]\n" +
                "}\n";
		
		Gson gson = new GsonBuilder().create();
		TypesResponse types = gson.fromJson(JsonString, TypesResponse.class);
		String i = "";
	}
}
