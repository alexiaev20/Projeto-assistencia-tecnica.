package Modelo;

public class Servico {

	private String[] SERVICO = {"Limpeza", 
			"Troca de Tela", 
			"Formatacao", 
			"Troca de HD", 
			 };
	
	Double[] VALORES = {50.00,
			 200.00,
			 150.00, 
		     300.00,
		  
		
	};

	public String[] getSERVICO() {
		return this.SERVICO;
	}

	public void setSERVICO(String[] SERVICO) {
		this.SERVICO = SERVICO;
	}

	public Double[] getVALORES() {
		return VALORES;
	}

	public void setVALORES(Double[] VALORES) {
		this.VALORES = VALORES;
	}
}