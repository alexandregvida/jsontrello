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
		String branchs = "2018SD-0150";
	    //List<acoesBranch> acoes = new ArrayList<acoesBranch>();
		acoesBranch teste = new acoesBranch();
		teste.setBranch(branchs);

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

			Object jsonObj4 = (jsonObject4.get("type"));
			// System.out.println("Data " + jsonObj4.toString());

			//JSONObject jsonObject5 = (JSONObject) jsonObj4;
			System.out.println(jsonObj4.toString());
			if (jsonObj4.toString().contains("updateCard")) {
				if (jsonObject3.get(i).toString().contains(branchs)) {
					//System.out.println("Aqui  " + jsonObject4.toString());
					teste.setAcoes(jsonObject4.toString());
				}
			}

		}
		System.out.println(teste.getBranch());
		System.out.println(teste.getAcoes());
		System.out.println("Total de acoes feitas na branch: " +teste.quantDisponibilizacoes());
		//System.out.println(acoes.get(0).getBranch());
		//System.out.println(acoes.get(0).getAcoes());
		// System.out.println(acoes.getAcoes().size());
		reader.close();
	}

}
