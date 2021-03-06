
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

import uk.ac.kcl.course.json_lib.dto.JSONQuery;
import uk.ac.kcl.course.json_lib.dto.JSONQueryBuilder;
import uk.ac.kcl.course.json_lib.service.JSONQueryProcess;


public class JSONQueryMain {

	    public static void main(String[] args) {
			
			JSONQuery json0= new JSONQueryBuilder()
			      	.setOperationValue("DATA")
			      	.setFirstQueryKey("gender")
			      	.setFirstQueryValue("Female")
			      	.setConnectorValue("AND")
			      	.setSecondQueryKey("isVaccinated")
			      	.setSecondQueryValue("No")
			      	.build();
			      	
			
			JSONQuery json1= new JSONQueryBuilder()
			      	.setOperationValue("COUNT")
			      	.setFirstQueryKey("isVaccinated")
			      	.setFirstQueryValue("Yes")
			      	.build();
			      	
			
			JSONQuery json2= new JSONQueryBuilder()
			      	.setOperationValue("AVG")
			      	.setAggregateField("income")
			      	.setFirstQueryKey("gender")
			      	.setFirstQueryValue("Male")
			      	.setConnectorValue("AND")
			      	.setSecondQueryKey("isVaccinated")
			      	.setSecondQueryValue("No")
			      	.build();
			      	
			
			JSONQuery json3= new JSONQueryBuilder()
			      	.setOperationValue("DATA")
			      	.setFirstQueryKey("countryCode")
			      	.setFirstQueryValue("US")
			      	.setConnectorValue("OR")
			      	.setSecondQueryKey("countryCode")
			      	.setSecondQueryValue("CN")
			      	.build();
			      	
			List<JSONQuery> jsonList = Arrays.asList(json0,json1,json2,json3);
			JSONQueryProcess jsonProcess = new JSONQueryProcess(jsonList);
			Map<String, List<JSONObject>> map = jsonProcess.processJSONQuery();
			System.out.println("Json:"+map.toString());
		}
}
