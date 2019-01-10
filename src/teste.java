import java.io.FileReader;
import java.io.Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class teste {

	public static void main(String[] args) throws IOException, ParseException {
		
		//PROD
		//String nome = "/home/alexandre/gitHub/jsontrello/Files/QPczEdsF.json";
		
		//DEV
		String nome = "/home/alexandre/gitHub/jsontrello/Files/sgo8GdIi.json";
		String branch = "2018SD-0122";
		ArrayList<String> contem = new ArrayList<>(); 
		
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(nome);

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		JSONArray actions = (JSONArray) jsonObject.get("actions");
		@SuppressWarnings("unchecked")
		Iterator<String> it = actions.iterator();
		//System.out.println("Actions " + actions.toString());
		
				
		JSONParser parser2 = new JSONParser();
	
		String testeActions = actions.toString();

		Object jsonObj2 = parser2.parse(testeActions);				
		
		JSONArray jsonObject3 = (JSONArray) jsonObj2;
		@SuppressWarnings("unchecked")
		Iterator<String> it2 = jsonObject3.iterator();
		//System.out.println("jsonObject3 " + jsonObject3.toString());

		//System.out.println(jsonObject3.size());
		//System.out.println("0");
		for(int i = 0; i <= jsonObject3.size(); i++) {
			
			JSONObject jsonObject4 = (JSONObject) jsonObject3.get(i);
			
			Object jsonObj4 = (jsonObject4.get("data"));
			//System.out.println("Data " + jsonObj4.toString());
			
			
			JSONObject jsonObject5 = (JSONObject) jsonObj4;
			
			Object jsonObj5 = (jsonObject5.get("card"));
			//System.out.println("Card " + jsonObj5.toString());
			
			JSONObject jsonObject6 = (JSONObject) jsonObj5;
			

			Object jsonObj6 = (jsonObject6.get("name"));
			System.out.println("Name " + jsonObj6.toString());
			
			if (jsonObj6.toString().contains(branch)) {
				contem.add(jsonObj6.toString());
			}
			
		}
		System.out.println(contem);

		

		





		
		
		
		

		
		
		
		
//		JSONArray cards = (JSONArray) jsonObject2.get("text");
//		@SuppressWarnings("unchecked")
//		Iterator<String> it2 = cards.iterator();
//		System.out.println("Data " + cards.toString());
		
		
//		JSONArray data = (JSONArray) jsonObject2.get("data");
//		@SuppressWarnings("unchecked")
//		Iterator<String> it2 = data.iterator();
//		System.out.println("Date " + data.toString());
		




		
		

				
		reader.close();
	}
	
}
