package uk.ac.kcl.course.json_lib.mapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;

public class JsonMapper {


	public JSONArray convertToJsonArray() {
		String jsonVaccinationArray = null;
		try {
			jsonVaccinationArray = readFile();
			JSONArray jsonArray = new JSONArray(jsonVaccinationArray);
			return jsonArray;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static String readFile() throws FileNotFoundException {
		
		InputStream fis = new FileInputStream("src/resource/covid_vaccination.json");
		StringBuilder result = new StringBuilder();
		try (InputStreamReader inStrmRdr = new InputStreamReader(fis);) {

			if (fis != null) {

				BufferedReader buffRdr = new BufferedReader(inStrmRdr);
				String fileContent;

				while ((fileContent = buffRdr.readLine()) != null) {
					result.append(fileContent);
				}
				fis.close();
			}
		} catch (Exception _e) {
			_e.printStackTrace();
		}
		return result.toString();
	}
}
