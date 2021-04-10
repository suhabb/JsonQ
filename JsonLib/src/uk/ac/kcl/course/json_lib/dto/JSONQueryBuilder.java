package uk.ac.kcl.course.json_lib.dto;

public class JSONQueryBuilder {

	private String operationKey;
	private String operationValue;
	private String firstQueryKey;
	private String firstQueryValue;
	private String connectorKey;
	private String connectorValue;
	private String secondQueryKey;
	private String secondQueryValue;
	private String aggregateField;

	public JSONQueryBuilder setOperationKey(String operationKey) {
		this.operationKey = operationKey;
		return this;
	}
	
	public JSONQueryBuilder setOperationValue(String operationValue) {
		this.operationValue = operationValue;
		return this;
	}

	public JSONQueryBuilder setFirstQueryKey(String firstQueryKey) {
		this.firstQueryKey = firstQueryKey;
		return this;
	}

	public JSONQueryBuilder setFirstQueryValue(String firstQueryValue) {
		this.firstQueryValue = firstQueryValue;
		return this;
	}

	public JSONQueryBuilder setConnectorKey(String connectorKey) {
		this.connectorKey= connectorKey;
		return this;
	}
	
	public JSONQueryBuilder setConnectorValue(String connectorValue) {
		this.connectorValue= connectorValue;
		return this;
	}

	public JSONQueryBuilder setSecondQueryKey(String secondQueryKey) {
		this.secondQueryKey = secondQueryKey;
		return this;
	}

	public JSONQueryBuilder setSecondQueryValue(String secondQueryValue) {
		this.secondQueryValue = secondQueryValue;
		return this;
	}
	
	public JSONQueryBuilder setAggregateField(String aggregateField) {
		this.aggregateField = aggregateField;
		return this;
	}
	

	public JSONQuery build() {
		JSONQuery json = new JSONQuery();
		json.setOperationKey(operationKey);
		json.setOperationValue(operationValue);
		json.setFirstQueryKey(firstQueryKey);
		json.setFirstQueryValue(firstQueryValue);
		json.setConnectorKey(connectorKey);
		json.setConnectorValue(connectorValue);
		json.setSecondQueryKey(secondQueryKey);
		json.setSecondQueryValue(secondQueryValue);
		json.setAggregateField(aggregateField);
        return json;

    }

}
