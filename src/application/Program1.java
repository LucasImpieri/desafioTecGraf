package application;

import java.util.ArrayList;

import util.Matricula;

public class Program1 {

	public static void main(String[] args) {
		
		//PARTE 1 - GERANDO MATRICULAS COM DIGITO HEXADECIMAL
		String arq = "matriculasSemDV.txt";
		String mat = Matricula.read(arq);
		
		String [] linhas = null;
		ArrayList<String> list = new ArrayList<>();
		
		if (mat.isEmpty()) {
			System.out.println("Erro ao ler do arquivo!");
		} else {
			linhas = mat.split("\n");
			System.out.println("Matriculas Sem DV: ");		
			for (int i = 0; i<linhas.length;i++) {
				list.add(linhas[i]);
				System.out.println(list.get(i));
			}
		} 
		
		list = Matricula.conversaoHexa(list);
		System.out.println();
		if (Matricula.write("matriculasComDV.txt", list)) {
			System.out.println("Matriculas salvas em 'matriculasComDv.txt'!");
		} else {
			System.out.println("Erro ao salvar as matriculas");
		}
		
		System.out.println();
		System.out.println("Matriculas Com DV: ");
		for (int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//PARTE 2 - VERIFICANDO MATRICULAS
		
		String arq2 = "matriculasParaVerificar.txt";
		String mat2 = Matricula.read(arq2);
		
		String [] linhas2 = null;
		ArrayList<String> paraVerif = new ArrayList<>();
		ArrayList<String> comp = new ArrayList<>();
		
		System.out.println();
		System.out.println("Matriculas Para Verificar: ");
		if (mat2.isEmpty()) {
			System.out.println("Erro ao ler do arquivo!");
		} else {
			linhas2 = mat2.split("\n");
					
			for (int i = 0; i<linhas2.length;i++) {
				paraVerif.add(linhas2[i]);
				System.out.println(paraVerif.get(i));
			}
		} 
		
		ArrayList<String> auxiliar = new ArrayList<String>();
		System.out.println();
		System.out.println("LISTA AUXILIAR: ");
		if (mat2.isEmpty()) {
			System.out.println("Erro ao ler do arquivo!");
		} else {
			linhas2 = mat2.split("\n");
					
			for (int i = 0; i<linhas2.length;i++) {
				auxiliar.add(linhas2[i]);
				System.out.println(auxiliar.get(i));
			}
		} 
		
		System.out.println();
		System.out.println("Matriculas Para Comparacao: ");
		comp = Matricula.conversaoHexa2(auxiliar);
		for (int i = 0; i<comp.size();i++) {
			System.out.println(comp.get(i));
		}
		
		paraVerif = Matricula.verificacao(paraVerif, comp);
		System.out.println();
		if (Matricula.write("matriculasVerificadas.txt", paraVerif)) {
			System.out.println("Matriculas salvas em 'matriculasVerificadas.txt'!");
		} else {
			System.out.println("Erro ao salvar as matriculas");
		}
		
		System.out.println();
		System.out.println("Matriculas Verificadas: ");
		for (int i = 0; i<paraVerif.size();i++) {
			System.out.println(paraVerif.get(i));
		}
	}
}
