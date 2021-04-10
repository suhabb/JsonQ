package uk.ac.kcl.course.json_lib.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.ac.kcl.course.json_lib.constant.ConnectorEnum;
import uk.ac.kcl.course.json_lib.constant.OperationEnum;
import uk.ac.kcl.course.json_lib.dto.JSONQuery;
import uk.ac.kcl.course.json_lib.mapper.JsonMapper;
import uk.ac.kcl.course.swing.JsonDSLUI;

public class JSONQueryProcess {

	private List<JSONQuery> jsonQueryList;

	public JSONQueryProcess(List<JSONQuery> jsonList) {
		this.jsonQueryList = jsonList;
	}

	public Map<String, List<JSONObject>> processJSONQuery() {

		JSONArray databaseArray = new JsonMapper().convertToJsonArray();
		Map<String, List<JSONObject>> map = new HashMap<String, List<JSONObject>>();

		for (int indexOfJSON = 0; indexOfJSON < jsonQueryList.size(); indexOfJSON++) {
			JSONQuery jsonQuery = jsonQueryList.get(indexOfJSON);
			String firstQueryKey = jsonQuery.getFirstQueryKey();
			String firstQueryValue = jsonQuery.getFirstQueryValue();
			String connector = jsonQuery.getConnectorValue();

			String operation = jsonQuery.getOperationValue();
			if (operation.equalsIgnoreCase(OperationEnum.DATA.name())) {
				List<JSONObject> listOfJson = searchByQuery(databaseArray, map, indexOfJSON, jsonQuery, firstQueryKey,
						firstQueryValue, connector);
				map.put(OperationEnum.DATA.name() + indexOfJSON, listOfJson);
			} else if (operation.equalsIgnoreCase(OperationEnum.COUNT.name())) {

				List<JSONObject> listOfJSONObject = searchByQuery(databaseArray, map, indexOfJSON, jsonQuery,
						firstQueryKey, firstQueryValue, connector);
				long count = listOfJSONObject.size();
				JSONObject countJson = new JSONObject();
				countJson.put(OperationEnum.COUNT.name(), count);

				map.put(OperationEnum.COUNT.name() + indexOfJSON, Arrays.asList(countJson));
			} else if (operation.equalsIgnoreCase(OperationEnum.AVG.name())) {
				List<JSONObject> listOfJSONObject = searchByQuery(databaseArray, map, indexOfJSON, jsonQuery,
						firstQueryKey, firstQueryValue, connector);
				String aggregateField = jsonQuery.getAggregateField();
				double average = listOfJSONObject.stream().map(json -> json.getString(aggregateField))
						.mapToInt(Integer::parseInt).average().orElse(0);
				average = Math.round(average * 100.0) / 100.0;
				JSONObject jsonObject = new JSONObject();
				jsonObject.put(OperationEnum.AVG.name(), average);
				map.put(OperationEnum.AVG.name() + indexOfJSON, Arrays.asList(jsonObject));

			}
		}
		buildJFrame(map);
		return map;

	}

	private List<JSONObject> searchByQuery(JSONArray databaseArray, Map<String, List<JSONObject>> map, int indexOfJSON,
			JSONQuery jsonQuery, String firstQueryKey, String firstQueryValue, String connector) {

		List<JSONObject> listOfJson = new ArrayList<JSONObject>();
		for (int index = 0; index < databaseArray.length(); index++) {
			JSONObject dbJSONObj = (JSONObject) databaseArray.get(index);

			if (Objects.isNull(connector) || connector.isEmpty()) {
				String dbFirstQueryValue = dbJSONObj.getString(firstQueryKey);

				if (Objects.nonNull(dbFirstQueryValue) && dbFirstQueryValue.equalsIgnoreCase(firstQueryValue)) {
					listOfJson.add(dbJSONObj);
				}
			} else {
				if (connector.equalsIgnoreCase(ConnectorEnum.AND.name())) {
					String dbFirstQueryValue = dbJSONObj.getString(firstQueryKey);
					String secondQueryKey = jsonQuery.getSecondQueryKey();
					String secondQueryValue = jsonQuery.getSecondQueryValue();
					String dbSecondQueryValue = (String) dbJSONObj.get(secondQueryKey);
					if ((Objects.nonNull(dbFirstQueryValue) && dbFirstQueryValue.equalsIgnoreCase(firstQueryValue))
							&& ((Objects.nonNull(dbSecondQueryValue)
									&& dbSecondQueryValue.equalsIgnoreCase(secondQueryValue)))) {
						listOfJson.add(dbJSONObj);
					}
				} else if (connector.equalsIgnoreCase(ConnectorEnum.OR.name())) {
					String dbFirstQueryValue = dbJSONObj.getString(firstQueryKey);
					String secondQueryKey = jsonQuery.getSecondQueryKey();
					String secondQueryValue = jsonQuery.getFirstQueryValue();
					String dbSecondQueryValue = dbJSONObj.getString(secondQueryKey);
					if ((Objects.nonNull(dbFirstQueryValue) && dbFirstQueryValue.equalsIgnoreCase(firstQueryValue))
							|| ((Objects.nonNull(dbSecondQueryValue)
									&& dbSecondQueryValue.equalsIgnoreCase(secondQueryValue)))) {
						if (Objects.nonNull(dbFirstQueryValue)) {
							listOfJson.add(dbJSONObj);
						} else if (Objects.nonNull(dbSecondQueryValue)) {
							listOfJson.add(dbJSONObj);
						}
					}
				}

			}

		}
		return listOfJson;
	}

	private void buildJFrame(Map<String, List<JSONObject>> map) {
		JsonDSLUI jsonbDslui = new JsonDSLUI();
		jsonbDslui.buildJFrameTable(map);

	}

	@Override
	public String toString() {
		return "JSONQueryProgram  jsonQueryList=" + jsonQueryList + "]";
	}

}
