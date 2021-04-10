package uk.ac.kcl.course.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.json.JSONObject;

import uk.ac.kcl.course.json_lib.constant.OperationEnum;

public class JsonDSLUI {

	public void buildJFrameTable(Map<String, List<JSONObject>> map) {
		


		for (String key : map.keySet()) {
			if (key.startsWith(OperationEnum.DATA.name())) {
				JFrame jFrame = new JFrame(key);
				jFrame.setPreferredSize(new Dimension(600, 300));
				JTable jTable = convertDataToTabularView(map.get(key));
				jTable.setEnabled(false);
				jFrame.setLocationRelativeTo(null);
				jFrame.add(new JScrollPane(jTable), BorderLayout.SOUTH);
				jFrame.add(new JScrollPane(jTable));
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.pack();
				jFrame.setVisible(true);
			

			} else if (key.startsWith(OperationEnum.COUNT.name())) {
				JFrame jFrame = new JFrame(key);
				jFrame.setPreferredSize(new Dimension(600, 300));
				JTable jTable = convertCountToTabularView(map.get(key));
				jTable.setEnabled(false);
				jFrame.setLocationRelativeTo(null);
				jFrame.add(new JScrollPane(jTable), BorderLayout.NORTH);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.pack();
				jFrame.setVisible(true);
			} else if (key.startsWith(OperationEnum.AVG.name())) {
				JFrame jFrame = new JFrame(key);
				jFrame.setPreferredSize(new Dimension(600, 300));
				JTable jTable = convertAverageToTabularView(map.get(key));
				jTable.setEnabled(false);
				jFrame.setLocationRelativeTo(null);
				jFrame.add(new JScrollPane(jTable), BorderLayout.WEST);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.pack();
				jFrame.setVisible(true);
			}
		}

	}

	public JTable convertDataToTabularView(List<JSONObject> listOfDataResult) {
		String columnArray[] = { "First Name", "Last Name", "Gender", "Country Code", "City Name", "Vaccinated",
				"Income" };

		String[][] data = new String[listOfDataResult.size()][7];
		for (int row = 0; row < data.length; row++) {
			JSONObject jsonObject = listOfDataResult.get(row);
			String firstName = jsonObject.getString("firstName");
			String lastName = jsonObject.getString("lastName");
			String gender = jsonObject.getString("gender");
			String countryCode = jsonObject.getString("countryCode");
			String cityName = jsonObject.getString("cityName");
			String isVaccinated = jsonObject.getString("isVaccinated");
			String income = jsonObject.getString("income");
			String[] rowArray = { firstName, lastName, gender, countryCode, cityName, isVaccinated, income };
			for (int column = 0; column < data[row].length; column++) {
				data[row][column] = rowArray[column];
			}
		}
		JTable jTable = new JTable(data, columnArray);
		return jTable;
	}

	public JTable convertCountToTabularView(List<JSONObject> listOfCountResult) {

		String columnArray[] = new String[] { "COUNT" };

		String[][] data = new String[listOfCountResult.size()][1];
		for (int row = 0; row < data.length; row++) {
			JSONObject jsonObject = listOfCountResult.get(row);
			Integer count = jsonObject.getInt(OperationEnum.COUNT.name());
			String[] rowArray = { String.valueOf(count) };
			for (int column = 0; column < data[row].length; column++) {
				data[row][column] = rowArray[column];
			}
		}
		JTable jTable = new JTable(data, columnArray);

		return jTable;
	}

	public JTable convertAverageToTabularView(List<JSONObject> listOfAverageResult) {

		String columnArray[] = new String[] { "AVG" };

		String[][] data = new String[listOfAverageResult.size()][1];
		for (int row = 0; row < data.length; row++) {
			JSONObject jsonObject = listOfAverageResult.get(row);
			double average = jsonObject.getDouble(OperationEnum.AVG.name());
			String[] rowArray = { String.valueOf(average) };
			for (int column = 0; column < data[row].length; column++) {
				data[row][column] = rowArray[column];
			}
		}
		JTable jTable = new JTable(data, columnArray);
		return jTable;
	}

}
