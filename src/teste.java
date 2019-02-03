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

		// PROD
		 String nome = "/home/alexandre/gitHub/jsontrello/Files/QPczEdsF.json";

		// DEV
		//String nome = "/home/alexandre/gitHub/jsontrello/Files/sgo8GdIi.json";

		ArrayList<String> branchs = new ArrayList<>();
		branchs.add("2018SD-0125");
		branchs.add("2018SD-0121");
		// String branch = "2016SD-0228-fase-2";
		List<acoesBranch> acoes = new ArrayList<acoesBranch>();
		acoesBranch teste = new acoesBranch();

		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(nome);

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		JSONArray actions = (JSONArray) jsonObject.get("actions");
		@SuppressWarnings("unchecked")
		Iterator<String> it = actions.iterator();
		// System.out.println("Actions " + actions.toString());

		JSONParser parser2 = new JSONParser();

		String testeActions = actions.toString();

		Object jsonObj2 = parser2.parse(testeActions);

		JSONArray jsonObject3 = (JSONArray) jsonObj2;
		@SuppressWarnings("unchecked")
		Iterator<String> it2 = jsonObject3.iterator();
		// System.out.println("jsonObject3 " + jsonObject3.toString());

		// System.out.println(jsonObject3.size());
		// System.out.println(jsonObject3.size());
		for (int i = 0; i < jsonObject3.size(); i++) {

			JSONObject jsonObject4 = (JSONObject) jsonObject3.get(i);

			Object jsonObj4 = (jsonObject4.get("data"));
			// System.out.println("Data " + jsonObj4.toString());

			JSONObject jsonObject5 = (JSONObject) jsonObj4;
			if (jsonObj4.toString().contains("card")) {
				Object jsonObj5 = (jsonObject5.get("card"));
				// System.out.println("Card " + jsonObj5.toString());

				JSONObject jsonObject6 = (JSONObject) jsonObj5;
				if (jsonObj5.toString().contains("name")) {
					Object jsonObj6 = (jsonObject6.get("name"));
					// System.out.println("Name " + jsonObj6.toString());
					// System.out.println(i);

					for (int j = 0; j < branchs.size(); j++) {
						if (jsonObj6.toString().contains(branchs.get(j))) {
							if (teste.getBranch() == (null)) {
								teste.setBranch(branchs.get(j));
							}
							if (!(teste.getBranch().contains((branchs.get(j))))) {
								teste.setBranch(branchs.get(j));
							}
							teste.setAcoes(jsonObj4.toString());
						}
						//System.out.println(teste.acoes.size());
					}
					acoes.add(teste);
				}
			}

		}
		System.out.println(acoes.size());
		for(int z = 0; z < acoes.size();z ++) {
			System.out.println(acoes.get(z).getBranch());
			System.out.println(acoes.get(z).getAcoes());
		}
		//System.out.println(acoes.get(0).getBranch());
		//System.out.println(acoes.get(0).getAcoes());
		// System.out.println(acoes.getAcoes().size());
		reader.close();
	}

}
