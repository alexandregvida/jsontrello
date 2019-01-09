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
		
		//Casa
		//String nome = "/home/alexandre/gitHub/jsontrello/Files/sgo8GdIi.json"
		
		//ValeCard
		String nome = "/home/alexandre/gitHub/jsontrello/Files/sgo8GdIi.json";
		
		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(nome);

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		JSONArray actions = (JSONArray) jsonObject.get("actions");
		@SuppressWarnings("unchecked")
		Iterator<String> it = actions.iterator();
		System.out.println("Actions " + actions.toString());
		
				
		JSONParser parser2 = new JSONParser();
		
		String testeActions = actions.toString();
		testeActions = testeActions.replace("[", "");
		testeActions = testeActions.replace("]", "");
		System.out.println("Actions " + testeActions);

		Object jsonObj2 = parser2.parse(testeActions);				
		
		//JSONObject jsonObject3 = (JSONObject) jsonObj2;
		JSONArray jsonObject3 = (JSONArray) jsonObj2;
		@SuppressWarnings("unchecked")
		Iterator<String> it2 = jsonObject3.iterator();
		System.out.println("jsonObject3 " + jsonObject3.toString());

		
		
				
////		JSONParser parser3 = new JSONParser();
//		Object jsonObj3 = (jsonObject3.get("data"));
//		System.out.println("Data " + jsonObject3.toString());		
//		
//		JSONObject jsonObject4 = (JSONObject) jsonObj3;
//		
////		JSONParser parser4 = new JSONParser();
//		Object jsonObj4 = (jsonObject4.get("list"));
//		System.out.println("List " + jsonObject4.toString());
//
//		
//		JSONObject jsonObject5 = (JSONObject) jsonObj4;
//		
//		String name = (String) jsonObject5.get("name");
//		System.out.println("name = " + name);




		
		
		
		

		
		
		
		
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
