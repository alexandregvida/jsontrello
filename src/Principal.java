import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Principal {

	public static void main(String[] args) {
		
		//String nome = "/home/alexandre/Downloads/QPczEdsF.json";
		String nome = "/home/alexandre/Downloads/arRRW8nS.json";
	    String branch = "2016SD-0228-fase-2";
	    
	    List<String> encontrados = null; 
	 
	    System.out.printf("\nConteúdo do arquivo texto:\n");
	    try {
	      FileReader arq = new FileReader(nome);
	      BufferedReader lerArq = new BufferedReader(arq);
	 
	      String linha = lerArq.readLine(); // lê a primeira linha
		       
	    //instancia um novo JSONObject passando a string como entrada
	    JSONObject my_obj = new JSONObject(linha);

	    String titulo = my_obj.getString("desc");
	    
	    System.out.println(titulo);
	    
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	}
}
