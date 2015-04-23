package CentersModdel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonTestCenter
{
	public static void main(String[] args){

		String JsonString ="{\n" +
                "\t\"url\": \"https:\\/\\/api2.sats.com\\/v1.0\\/se\\/centers\",\n" +
                "\t\"userId\": \"\",\n" +
                "\t\"regions\": [{\n" +
                "\t\"center\": [{\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till ett av Stockholms trevligaste familjecenter.\",\n" +
                "\t\"filterId\": \"533\",\n" +
                "\t\"id\": \"109\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.442326389884713,\n" +
                "\t\"long\": 18.096241794738717,\n" +
                "\t\"name\": \"Viggbyholm (tidigare Täby)\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/taby\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Södra Station har en personlig atmosfär och är beläget mitt på Södermalm. Vi erbjuder en härlig blandning av träning fördelat på 1800 kvm.\",\n" +
                "\t\"filterId\": \"554\",\n" +
                "\t\"id\": \"110\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.311907200703565,\n" +
                "\t\"long\": 18.057875476989693,\n" +
                "\t\"name\": \"Södra Station\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sodra-station\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Träningscentret ligger beläget på övre plan, bredvid Åhlens, vid delen av Gallerian som vetter mot Science Tower.\",\n" +
                "\t\"filterId\": \"521\",\n" +
                "\t\"id\": \"111\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.401637911577481,\n" +
                "\t\"long\": 17.946526251945443,\n" +
                "\t\"name\": \"Kista\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/kista\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Vi har SATS största och första Prformance-anläggning med över 300 kvm för funktionell träning.\",\n" +
                "\t\"filterId\": \"506\",\n" +
                "\t\"id\": \"112\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.333184252094547,\n" +
                "\t\"long\": 18.067767463836617,\n" +
                "\t\"name\": \"Regeringsgatan\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/regeringsgatan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS modernaste center, beläget mitt i centrala Stockholm.\",\n" +
                "\t\"filterId\": \"530\",\n" +
                "\t\"id\": \"113\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.332379831032469,\n" +
                "\t\"long\": 18.060246549758858,\n" +
                "\t\"name\": \"Zenit\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/zenit\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": false,\n" +
                "\t\"description\": \"Välkommen till SATS Arlanda.\",\n" +
                "\t\"filterId\": \"535\",\n" +
                "\t\"id\": \"228\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.648977789232383,\n" +
                "\t\"long\": 17.930148683700509,\n" +
                "\t\"name\": \"Arlanda\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/arlanda\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till vårt lilla hemtrevliga center som ligger på Alviks Torg.\",\n" +
                "\t\"filterId\": \"536\",\n" +
                "\t\"id\": \"230\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.332336052468996,\n" +
                "\t\"long\": 17.98205479255671,\n" +
                "\t\"name\": \"Bromma\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/bromma\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Farsta är ett center med familjär anda.\",\n" +
                "\t\"filterId\": \"529\",\n" +
                "\t\"id\": \"232\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.24130812226781,\n" +
                "\t\"long\": 18.094181858215279,\n" +
                "\t\"name\": \"Farsta\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/farsta\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Fridhemsplan är beläget mitt i hjärtat av Kungsholmen.\",\n" +
                "\t\"filterId\": \"510\",\n" +
                "\t\"id\": \"235\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.333632968493362,\n" +
                "\t\"long\": 18.032035075340218,\n" +
                "\t\"name\": \"Fridhemsplan \",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/fridhemsplan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Slakthuset erbjuder en storslagen miljö. I en historisk byggnad lovar vi ett toppmodernt center i unik design med öppna ytor, stora fönster och en takhöjd på upp till 12 meter.\\u000d\\u000a\",\n" +
                "\t\"filterId\": \"504\",\n" +
                "\t\"id\": \"237\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.292871378409828,\n" +
                "\t\"long\": 18.079274140510506,\n" +
                "\t\"name\": \"Slakthuset \",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/globen\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Gärdet öppnade 2007 och är ett av två center som erbjuder våra medlemmar möjligheten att spela squash.\",\n" +
                "\t\"filterId\": \"549\",\n" +
                "\t\"id\": \"239\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.342110952780388,\n" +
                "\t\"long\": 18.112951956901497,\n" +
                "\t\"name\": \"Gärdet\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/gardet\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Haninge är beläget i närheten av Haninge Centrum.\",\n" +
                "\t\"filterId\": \"552\",\n" +
                "\t\"id\": \"241\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.175741632989727,\n" +
                "\t\"long\": 18.142998062286324,\n" +
                "\t\"name\": \"Haninge\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/haninge\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Hornstull har nya, ljusa och handikappanpassade lokaler på hela 2300 kvm. Centret erbjuder ett brett träningsutbud och MiniSats.\",\n" +
                "\t\"filterId\": \"551\",\n" +
                "\t\"id\": \"249\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.3158384642584,\n" +
                "\t\"long\": 18.03248032203669,\n" +
                "\t\"name\": \"Hornstull\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/hornstull\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Huddinge är Sveriges senast öppnade träningscenter.\",\n" +
                "\t\"filterId\": \"563\",\n" +
                "\t\"id\": \"252\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.235655380174627,\n" +
                "\t\"long\": 17.981386922512,\n" +
                "\t\"name\": \"Huddinge\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/huddinge\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till ett av Stockholms mest centrala center som öppnar redan kl. 05:00.\",\n" +
                "\t\"filterId\": \"513\",\n" +
                "\t\"id\": \"255\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.334779357258341,\n" +
                "\t\"long\": 18.064682923469491,\n" +
                "\t\"name\": \"Hötorget\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/hotorget\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Jakobsberg är ett träningscenter på 1300 kvm beläget på 2 våningar.\",\n" +
                "\t\"filterId\": \"558\",\n" +
                "\t\"id\": \"258\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.424807139759139,\n" +
                "\t\"long\": 17.83372863403315,\n" +
                "\t\"name\": \"Jakobsberg\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/jakobsberg\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Kungens Kurva är beläget i Heron city. Här erbjuder vi träning för hela familjen.\",\n" +
                "\t\"filterId\": \"545\",\n" +
                "\t\"id\": \"260\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.267613518002591,\n" +
                "\t\"long\": 17.910010658416695,\n" +
                "\t\"name\": \"Kungens Kurva\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/kungens-kurva\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Lidingö är beläget i AGA-området på den södra delen av Lidingö.\",\n" +
                "\t\"filterId\": \"548\",\n" +
                "\t\"id\": \"264\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.346019578357129,\n" +
                "\t\"long\": 18.154917799148507,\n" +
                "\t\"name\": \"Lidingö\\/Dalénum\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/lidingo\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Liljeholmstorget är beläget mitt i Liljeholmstorgets galleria med ett brett utbud av träning i form av styrke-, konditions- och gruppträning för hela familjen\",\n" +
                "\t\"filterId\": \"557\",\n" +
                "\t\"id\": \"268\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.309815451833927,\n" +
                "\t\"long\": 18.022051893386788,\n" +
                "\t\"name\": \"Liljeholmstorget\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/liljeholmstorget\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Marievik ligger beläget nere vid vattnet (Milleniumhuset) centralt i Liljeholmen. \",\n" +
                "\t\"filterId\": \"538\",\n" +
                "\t\"id\": \"269\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.309856521440125,\n" +
                "\t\"long\": 18.029009543571419,\n" +
                "\t\"name\": \"Marievik\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/marievik\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS Medborgarplatsen, ett av Stockholms populäraste och mest välbesökta träningscenter.\",\n" +
                "\t\"filterId\": \"509\",\n" +
                "\t\"id\": \"272\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.313738744246969,\n" +
                "\t\"long\": 18.075948201332039,\n" +
                "\t\"name\": \"Medborgarplatsen\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/medborgarplatsen\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS Märsta. \",\n" +
                "\t\"filterId\": \"539\",\n" +
                "\t\"id\": \"274\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.619332197100285,\n" +
                "\t\"long\": 17.85095914474482,\n" +
                "\t\"name\": \"Märsta\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/marsta\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Här uppmärksammar vi träningen som en del i den stora helheten, där välbefinnande står i fokus.\",\n" +
                "\t\"filterId\": \"540\",\n" +
                "\t\"id\": \"277\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.316210760921294,\n" +
                "\t\"long\": 18.162460170898385,\n" +
                "\t\"name\": \"Nacka Strand\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/nacka-strand\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Odenplan är Sveriges största center och har öppet mellan 06:00–24:00.\",\n" +
                "\t\"filterId\": \"511\",\n" +
                "\t\"id\": \"280\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.342999937937378,\n" +
                "\t\"long\": 18.052060447845406,\n" +
                "\t\"name\": \"Odenplan\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/odenplan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS S:t Eriksbron är beläget i Polarstudions före detta lokaler.\",\n" +
                "\t\"filterId\": \"556\",\n" +
                "\t\"id\": \"284\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.336538537340054,\n" +
                "\t\"long\": 18.035280548248238,\n" +
                "\t\"name\": \"S:t Eriksbron\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/st-eriksbron\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Sickla ligger beläget i Sickla Köpkvarter. Ett ljust och luftigt träningscenter med mycket generösa ytor och fönster från golv till tak. \",\n" +
                "\t\"filterId\": \"522\",\n" +
                "\t\"id\": \"286\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.305582278417191,\n" +
                "\t\"long\": 18.128331743392891,\n" +
                "\t\"name\": \"Sickla\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sickla\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": false,\n" +
                "\t\"description\": \"Vill du träna där historien talar sitt tydliga språk? Besök då vårat träningscenter i Sigtuna.\\u000d\\u000a\",\n" +
                "\t\"filterId\": \"541\",\n" +
                "\t\"id\": \"288\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.616776439429181,\n" +
                "\t\"long\": 17.722266756210274,\n" +
                "\t\"name\": \"Sigtuna\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sigtuna\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"På SATS Sollentuna hittar du 2 000 kvm handikappvänlig träningsyta med den senaste utrustningen i ljusa lokaler.\",\n" +
                "\t\"filterId\": \"562\",\n" +
                "\t\"id\": \"289\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.428654404361488,\n" +
                "\t\"long\": 17.953204952392525,\n" +
                "\t\"name\": \"Sollentuna\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sollentuna\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Stadion är beläget i närheten av elljusspåren i Lill-jansskogen på Gärdet, så du kan enkelt kombinera inomhusträning med utomhusträning.\",\n" +
                "\t\"filterId\": \"531\",\n" +
                "\t\"id\": \"292\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.34294523183047,\n" +
                "\t\"long\": 18.083839260253853,\n" +
                "\t\"name\": \"Stadion\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/stadion\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Sats Stadshagen är beläget vid Lindhagen på Kungsholmen.\",\n" +
                "\t\"filterId\": \"550\",\n" +
                "\t\"id\": \"295\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.339493098263752,\n" +
                "\t\"long\": 18.012492500457711,\n" +
                "\t\"name\": \"Stadshagen\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/stadshagen\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till ett av Stockholms populäraste och mest välbesökta träningscenter. \",\n" +
                "\t\"filterId\": \"512\",\n" +
                "\t\"id\": \"296\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.333917517285251,\n" +
                "\t\"long\": 18.075213276061959,\n" +
                "\t\"name\": \"Stureplan\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/stureplan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS Signalfabriken!\",\n" +
                "\t\"filterId\": \"508\",\n" +
                "\t\"id\": \"297\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.362379499559431,\n" +
                "\t\"long\": 17.965687953147835,\n" +
                "\t\"name\": \"Signalfabriken (Sundbyberg)\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sundbyberg\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Telefonplan ligger beläget i samma byggnad som Konstfack.\",\n" +
                "\t\"filterId\": \"544\",\n" +
                "\t\"id\": \"299\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.299749164747645,\n" +
                "\t\"long\": 17.9919950591659,\n" +
                "\t\"name\": \"Telefonplan\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/telefonplan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Tule är beläget i utkanten av Vasastan.\",\n" +
                "\t\"filterId\": \"501\",\n" +
                "\t\"id\": \"301\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.346342313895924,\n" +
                "\t\"long\": 18.057993494186348,\n" +
                "\t\"name\": \"Tule\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/tule\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Mitt i city kan du kombinera styrke- och konditionsträning med avkoppling.\",\n" +
                "\t\"filterId\": \"534\",\n" +
                "\t\"id\": \"303\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.330910482172328,\n" +
                "\t\"long\": 18.058870576534218,\n" +
                "\t\"name\": \"Vasagatan\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/vasagatan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS i Vällingby Centrum!\",\n" +
                "\t\"filterId\": \"517\",\n" +
                "\t\"id\": \"305\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.36383108558848,\n" +
                "\t\"long\": 17.871923290405221,\n" +
                "\t\"name\": \"Vällingby C\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/vallingby-c\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS Vällingby Parken.\",\n" +
                "\t\"filterId\": \"542\",\n" +
                "\t\"id\": \"307\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.358172009600153,\n" +
                "\t\"long\": 17.874584041747994,\n" +
                "\t\"name\": \"Vällingby Parken\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/vallingby-parken\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Norr om Stockholm hittar du familjära SATS Väsby.\",\n" +
                "\t\"filterId\": \"543\",\n" +
                "\t\"id\": \"308\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.497364819785545,\n" +
                "\t\"long\": 17.924553595695443,\n" +
                "\t\"name\": \"Väsby\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/vasby\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Älvsjö är ett ljust center, fördelat på 1400 kvm.\",\n" +
                "\t\"filterId\": \"547\",\n" +
                "\t\"id\": \"310\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.280835332012145,\n" +
                "\t\"long\": 18.013651214752144,\n" +
                "\t\"name\": \"Älvsjö\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/alvsjo\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Mitt i centrala Stockholm, på Birger Jarlsgatan 57D, ligger Nordens häftigaste träningscenter.\",\n" +
                "\t\"filterId\": \"564\",\n" +
                "\t\"id\": \"1489\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.341632258826579,\n" +
                "\t\"long\": 18.064296685371346,\n" +
                "\t\"name\": \"Spårvagnshallarna\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sparvagnshallarna\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Danderyd ligger beläget mitt i Mörby, beläget i norra Stockholm, några minuters promenad ifrån Mörby Centrum.\",\n" +
                "\t\"filterId\": \"567\",\n" +
                "\t\"id\": \"2321\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.400267133216417,\n" +
                "\t\"long\": 18.038756691131539,\n" +
                "\t\"name\": \"Danderyd\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/danderyd\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Centret ligger strategiskt beläget i Värmdö köpcentrum.\",\n" +
                "\t\"filterId\": \"572\",\n" +
                "\t\"id\": \"2795\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.311804532786631,\n" +
                "\t\"long\": 18.421642028007454,\n" +
                "\t\"name\": \"Värmdö\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/varmdo\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS har öppnat ett nytt center på Lumaparksvägen 5 i Hammarby Sjöstad.\",\n" +
                "\t\"filterId\": \"573\",\n" +
                "\t\"id\": \"3221\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.305089377926379,\n" +
                "\t\"long\": 18.0951581822967,\n" +
                "\t\"name\": \"Sjöstaden\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sjostaden\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS nya träningscenter, beläget i Täby Centrum, har en yta på ca 2 330 kvadratmeter i två plan.\",\n" +
                "\t\"filterId\": \"575\",\n" +
                "\t\"id\": \"3469\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.444639060533753,\n" +
                "\t\"long\": 18.071307979736275,\n" +
                "\t\"name\": \"Täby Centrum \",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/taby-centrum\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Den 6 oktober öppnar SATS Sveavägen som kommer erbjuda ett starkt gruppträningsutbud med extra fokus på yoga, cykel och löpning. \",\n" +
                "\t\"filterId\": \"576\",\n" +
                "\t\"id\": \"3701\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.339613463815908,\n" +
                "\t\"long\": 18.059527717742867,\n" +
                "\t\"name\": \"Sveavägen \",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/sveavagen\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"Välkommen till SATS Tuletorget (Sundbyberg), ett träningscenter som erbjuder det lilla extra. Här kan du välja på ett unikt utbud av gruppträning.\",\n" +
                "\t\"filterId\": \"577\",\n" +
                "\t\"id\": \"3713\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 59.364487149294348,\n" +
                "\t\"long\": 17.975005947265572,\n" +
                "\t\"name\": \"Tuletorget (Sundbyberg)\",\n" +
                "\t\"regionId\": \"108\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/stockholm\\/tuletorget\\/?mobile=1\"\n" +
                "\t}],\n" +
                "\t\"id\": \"108\",\n" +
                "\t\"name\": \"Stockholm\"\n" +
                "\t}, {\n" +
                "\t\"center\": [{\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Kompassen är Göteborgs mest centrala träningscenter.\",\n" +
                "\t\"filterId\": \"516\",\n" +
                "\t\"id\": \"117\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.705526143449141,\n" +
                "\t\"long\": 11.970178328666634,\n" +
                "\t\"name\": \"Kompassen\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/kompassen\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": false,\n" +
                "\t\"description\": \"SATS Frölunda erbjuder inspirerande träning på två plan.\",\n" +
                "\t\"filterId\": \"528\",\n" +
                "\t\"id\": \"118\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.652049164456237,\n" +
                "\t\"long\": 11.911421857986397,\n" +
                "\t\"name\": \"Frölunda\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/frolunda\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Kungsgatan är beläget mitt på Göteborgs shoppingstråk.\",\n" +
                "\t\"filterId\": \"518\",\n" +
                "\t\"id\": \"312\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.703863795118522,\n" +
                "\t\"long\": 11.962442837867684,\n" +
                "\t\"name\": \"Kungsgatan\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/kungsgatan\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Landala är beläget vid Kapellplatsen i stora och ljusa lokaler.\",\n" +
                "\t\"filterId\": \"561\",\n" +
                "\t\"id\": \"313\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.693326171518763,\n" +
                "\t\"long\": 11.971084915313668,\n" +
                "\t\"name\": \"Landala\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/landala\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Mölnlycke erbjuder 1450 kvm ljusa träningsytor med det senaste inom tränings- och konditionsmaskiner.\",\n" +
                "\t\"filterId\": \"555\",\n" +
                "\t\"id\": \"314\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.656233796001786,\n" +
                "\t\"long\": 12.117125831756539,\n" +
                "\t\"name\": \"Mölnlycke\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/molnlycke\\/?mobile=1\"\n" +
                "\t}, {\n" +
                "\t\"availableForOnlineBooking\": true,\n" +
                "\t\"description\": \"SATS Valhalla är beläget intill Svenska mässan och Scandinavium.\",\n" +
                "\t\"filterId\": \"507\",\n" +
                "\t\"id\": \"316\",\n" +
                "\t\"isElixia\": false,\n" +
                "\t\"lat\": 57.700214959602512,\n" +
                "\t\"long\": 11.99001058212275,\n" +
                "\t\"name\": \"Valhalla\",\n" +
                "\t\"regionId\": \"116\",\n" +
                "\t\"url\": \"http:\\/\\/www.sats.se\\/vara-center\\/goteborg\\/valhalla\\/?mobile=1\"\n" +
                "\t}]}]}";
	Gson gson = new GsonBuilder().create();
	AllRegions reg = gson.fromJson(JsonString, AllRegions.class);
	int i = 0;
	if(i == 0){
		
	}
	}
}
