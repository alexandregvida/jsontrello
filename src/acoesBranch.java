import java.util.ArrayList;

public class acoesBranch {

	private String branch;
	private ArrayList<String> acoes = new ArrayList<>();
	// private ArrayList<String> notas = new ArrayList<>();

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public ArrayList<String> getAcoes() {
		return acoes;
	}

	public void setAcoes(String acao) {
		this.acoes.add(acao);
	}

	public int quantDisponibilizacoes() {
		int quant = 0;
		for (int i = 0; i < acoes.size(); i++) {
			//if ((acoes.get(i).contains("listBefore")) && (acoes.get(i).contains("listAfter"))) {
				if ((acoes.get(i).contains("\"QA\\/HML\"") || (acoes.get(i).contains("\"QA\"")))) {
					quant++;
					//System.out.println(acoes.get(i));
				}
			//}
		}
		return quant;
	}

	@Override
	public String toString() {
		return acoes.toString();
	}

}
