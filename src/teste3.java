import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class teste3 {

	public static void main(String[] args) throws IOException, ParseException {

		// PROD
		String nome = "/home/alexandre/gitHub/jsontrello/Files/QPczEdsF.json";

		// DEV
		//String nome = "/home/alexandre/gitHub/jsontrello/Files/sgo8GdIi2.json";

		//String branchs = "2018SD-0121";
		String branchs = "2018SD-0044-frente-9";

		acoesBranch teste = new acoesBranch();
		teste.setBranch(branchs);

		JSONParser parser = new JSONParser();
		Reader reader = new FileReader(nome);

		Object jsonObj = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) jsonObj;

		JSONArray actions = (JSONArray) jsonObject.get("actions");
		@SuppressWarnings("unchecked")
		Iterator<String> it = actions.iterator();

		JSONParser parser2 = new JSONParser();

		String testeActions = actions.toString();

		Object jsonObj2 = parser2.parse(testeActions);

		JSONArray jsonObject3 = (JSONArray) jsonObj2;
		@SuppressWarnings("unchecked")
		Iterator<String> it2 = jsonObject3.iterator();

		
		for (int i = 0; i < jsonObject3.size(); i++) {

			JSONObject jsonObject4 = (JSONObject) jsonObject3.get(i);
			
			System.out.println(jsonObject3.get(i).toString());

			Object jsonObj4 = (jsonObject4.get("type"));

			//System.out.println("Ação: " + jsonObj4.toString());
			if (jsonObj4.toString().contains("updateCard")) {
				if (jsonObject3.get(i).toString().contains(branchs)) {
					//System.out.println("Aqui  " + jsonObject4.toString());
					teste.setAcoes(jsonObject4.toString());
				}
			}

		}
		//System.out.println("Branch: " + teste.getBranch());
//		System.out.println(teste.getAcoes());
		System.out.println("Quantidade total de açoes: " + teste.quantiTotal());
		System.out.println("Quantidade de açoes de disponibilização: " +teste.quantDisponibilizacoes());

		reader.close();
	}

}
