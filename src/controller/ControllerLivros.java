package controller;

import view.TelaLivros;

public class ControllerLivros {
	
	public void run() {
	TelaLivros telalivro = new TelaLivros();
	boolean continuar = true;
	
	do {
		String opc = telalivro.menuLivros();
		switch (opc) {
		case "1":
			telalivro.cadastroLivros();
			
			break;
		case "2":
			telalivro.AtualizarLivros();
			
			break;
		case "3":
			telalivro.DeletaLivros();
			break;
		case "4":
			telalivro.ListaLivros();
			break;
		default:
				System.out.println("Valor inválido!");
			break;
		};
		if(opc.equals("99")) {
			continuar = false;
		}
	}
	while(continuar);
	
	System.out.println("Finish!!");
	}
}
