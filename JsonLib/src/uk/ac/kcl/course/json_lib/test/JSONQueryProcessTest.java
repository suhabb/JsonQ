package uk.ac.kcl.course.json_lib.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import uk.ac.kcl.course.json_lib.dto.JSONQuery;
import uk.ac.kcl.course.json_lib.dto.JSONQueryBuilder;
import uk.ac.kcl.course.json_lib.service.JSONQueryProcess;

public class JSONQueryProcessTest {

	@Test
	public void given_input_test_json_response() {

		List<JSONQuery> jsonQueryList = getTestData();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	@Test
	public void given_input_test_json_Single_Query() {

		List<JSONQuery> jsonQueryList = getTestData2();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	@Test
	public void given_input_test_AND_operation() {

		List<JSONQuery> jsonQueryList = getTestData3();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	@Test
	public void given_input_test_COUNT_operation() {

		List<JSONQuery> jsonQueryList = getTestData4();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	@Test
	public void given_input_test_COUNT_operation2() {

		List<JSONQuery> jsonQueryList = getTestData5();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	@Test
	public void given_input_test_AVG_operation() {

		List<JSONQuery> jsonQueryList = getTestData6();

		Map<String, List<JSONObject>> map = new JSONQueryProcess(jsonQueryList).processJSONQuery();
		System.out.println("Map : " + map);

	}

	public List<JSONQuery> getTestData() {
		JSONQuery q1 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("firstName")
				.setFirstQueryValue("Welby").build();

		JSONQuery q2 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("cityName")
				.setFirstQueryValue("Datun").build();

		JSONQuery q3 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("isVaccinated")
				.setFirstQueryValue("Yes").setConnectorValue("AND").setSecondQueryKey("income")
				.setSecondQueryValue("72836").build();

		JSONQuery q4 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("isVaccinated")
				.setFirstQueryValue("Yes").setConnectorValue("OR").setSecondQueryKey("countryCode")
				.setSecondQueryValue("BR").build();

		List<JSONQuery> jsonList = Arrays.asList(q1, q2, q3, q4);
		return jsonList;
	}

	public List<JSONQuery> getTestData2() {
		JSONQuery q1 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("firstName")
				.setFirstQueryValue("Welby").build();

		List<JSONQuery> jsonList = Arrays.asList(q1);
		return jsonList;
	}

	public List<JSONQuery> getTestData3() {
		JSONQuery q3 = new JSONQueryBuilder().setOperationValue("DATA").setFirstQueryKey("isVaccinated")
				.setFirstQueryValue("Yes").setConnectorValue("AND").setSecondQueryKey("income")
				.setSecondQueryValue("72836").build();

		List<JSONQuery> jsonList = Arrays.asList(q3);
		return jsonList;
	}

	public List<JSONQuery> getTestData4() {
		JSONQuery q3 = new JSONQueryBuilder().setOperationValue("COUNT").setFirstQueryKey("isVaccinated")
				.setFirstQueryValue("Yes").setConnectorValue("AND").setSecondQueryKey("income")
				.setSecondQueryValue("72836").build();

		List<JSONQuery> jsonList = Arrays.asList(q3);
		return jsonList;
	}

	public List<JSONQuery> getTestData5() {
		JSONQuery q3 = new JSONQueryBuilder().setOperationValue("COUNT").setFirstQueryKey("isVaccinated")
				.setFirstQueryValue("Yes").build();

		List<JSONQuery> jsonList = Arrays.asList(q3);
		return jsonList;
	}

	public List<JSONQuery> getTestData6() {
		JSONQuery q3 = new JSONQueryBuilder().setOperationValue("AVG").setFirstQueryKey("isVaccinated")
				.setAggregateField("income").setFirstQueryValue("Yes").build();

		List<JSONQuery> jsonList = Arrays.asList(q3);
		return jsonList;
	}

}
