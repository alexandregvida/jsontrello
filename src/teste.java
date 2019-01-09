import java.io.FileReader;
import java.io.Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class teste {

	public static void main(String[] args) throws IOException, ParseException {
		
		//String nome = "/home/alexandre/Downloads/QPczEdsF.json";
		String nome = "/home/alexandre/Downloads/sgo8GdIi.json";
		
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(nome);

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		String name = (String) jsonObject.get("id");
		System.out.println("ID = " + name);

//		String age = (String) jsonObject.get("name");
//		System.out.println("Name = " + age);
		
//		String desc = (String) jsonObject.get("descData");
//		System.out.println("desc = " + desc);

		JSONArray cities = (JSONArray) jsonObject.get("actions");
		@SuppressWarnings("unchecked")
		Iterator<String> it = cities.iterator();
		while (it.hasNext()) {
			System.out.println("actions = " + it.next());
		}
		reader.close();
	}
	
}
