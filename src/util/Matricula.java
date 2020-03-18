package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Matricula {

	// Metodos
	public static String read(String Caminho) {
		String conteudo = "";
		try {
			FileReader arq = new FileReader(Caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					conteudo += linha + "\n";
					linha = lerArq.readLine();
				}
				arq.close();
				return conteudo;
			} catch (IOException ex) {
				System.out.println("Erro: Não foi possível ler o arquivo!");
				return "";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Erro: Arquivo não encontrado!");
			return "";
		}
	}

	public static boolean write(String Caminho, ArrayList<String> list) {
		try {
			FileWriter arq = new FileWriter(Caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			for (int i = 0; i < list.size(); i++) {
				gravarArq.println(list.get(i));
			}
			gravarArq.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static ArrayList<String> conversaoHexa(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {

			int sum = 0;
			int mil = 0;
			int cem = 0;
			int dez = 0;
			int uni = 0;
			if (list.get(i).length() == 4) {
				mil = Integer.parseInt(list.get(i).substring(0, 1));
				cem = Integer.parseInt(list.get(i).substring(1, 2));
				dez = Integer.parseInt(list.get(i).substring(2, 3));
				uni = Integer.parseInt(list.get(i).substring(3, 4));
			} else {
				System.out.println("Matricula errada!");
			}

			sum = mil * 5 + cem * 4 + dez * 3 + uni * 2;
			String hexa = Integer.toHexString(sum % 16).toUpperCase();
			String matC = mil + "" + cem + "" + dez + "" + uni + "-" + hexa;
			list.set(i, matC);
		}
		return list;

	}

	public static ArrayList<String> conversaoHexa2(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {

			int sum = 0;
			int mil = 0;
			int cem = 0;
			int dez = 0;
			int uni = 0;
			if (list.get(i).length() == 6) {
				mil = Integer.parseInt(list.get(i).substring(0, 1));
				cem = Integer.parseInt(list.get(i).substring(1, 2));
				dez = Integer.parseInt(list.get(i).substring(2, 3));
				uni = Integer.parseInt(list.get(i).substring(3, 4));
			} else {
				System.out.println("Matricula errada!");
			}

			sum = mil * 5 + cem * 4 + dez * 3 + uni * 2;
			String hexa = Integer.toHexString(sum % 16).toUpperCase();
			String matC = mil + "" + cem + "" + dez + "" + uni + "-" + hexa;
			list.set(i, matC);
		}
		return list;

	}

	//
	public static ArrayList<String> verificacao(ArrayList<String> list , ArrayList<String> list2) {
		for (int i = 0; i < list.size(); i++) {

			int digito = 0;
			int digito2 = 0;
			
			if (list.get(i).length() == 6) {
				digito = Integer.parseInt(list.get(i).substring(5, 6),16);
				digito2 = Integer.parseInt(list2.get(i).substring(5, 6),16);
			} else {
				System.out.println("Matricula errada!");
			}
			if (digito == digito2) {
				list.set(i, list.get(i) + " verdadeiro");
			} else {
				list.set(i, list.get(i) + " falso");;
			}
		}
		return list;

	}
}
