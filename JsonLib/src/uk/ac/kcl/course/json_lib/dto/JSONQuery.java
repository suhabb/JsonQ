package uk.ac.kcl.course.json_lib.dto;

public class JSONQuery {
	
	private String operationKey;
	private String operationValue;
	private String firstQueryKey;
	private String firstQueryValue;
	private String connectorKey;
	private String connectorValue;
	private String secondQueryKey;
	private String secondQueryValue;
	private String aggregateField;
	
	public String getOperationKey() {
		return operationKey;
	}
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey;
	}
	public String getOperationValue() {
		return operationValue;
	}
	public void setOperationValue(String operationValue) {
		this.operationValue = operationValue;
	}
	public String getFirstQueryKey() {
		return firstQueryKey;
	}
	public void setFirstQueryKey(String firstQueryKey) {
		this.firstQueryKey = firstQueryKey;
	}
	public String getFirstQueryValue() {
		return firstQueryValue;
	}
	public void setFirstQueryValue(String firstQueryValue) {
		this.firstQueryValue = firstQueryValue;
	}
	public String getConnectorKey() {
		return connectorKey;
	}
	public void setConnectorKey(String connectorKey) {
		this.connectorKey = connectorKey;
	}
	public String getConnectorValue() {
		return connectorValue;
	}
	public void setConnectorValue(String connectorValue) {
		this.connectorValue = connectorValue;
	}
	public String getSecondQueryKey() {
		return secondQueryKey;
	}
	public void setSecondQueryKey(String secondQueryKey) {
		this.secondQueryKey = secondQueryKey;
	}
	public String getSecondQueryValue() {
		return secondQueryValue;
	}
	public void setSecondQueryValue(String secondQueryValue) {
		this.secondQueryValue = secondQueryValue;
	}
	public String getAggregateField() {
		return aggregateField;
	}
	public void setAggregateField(String aggregateField) {
		this.aggregateField = aggregateField;
	}
	
	@Override
	public String toString() {
		return "JSONQuery [operationKey=" + operationKey + ", operationValue=" + operationValue + ", firstQueryKey="
				+ firstQueryKey + ", firstQueryValue=" + firstQueryValue + ", connectorKey=" + connectorKey
				+ ", connectorValue=" + connectorValue + ", secondQueryKey=" + secondQueryKey + ", secondQueryValue="
				+ secondQueryValue + ", aggregateField=" + aggregateField + "]";
	}
	

}
