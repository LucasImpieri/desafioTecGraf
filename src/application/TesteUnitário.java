package application;

import java.util.Scanner;

public class TesteUnitário {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com a matricula: ");
		String m1 = sc.nextLine();
        int sum = 0;
        int mil = 0;
        int cem = 0;
        int dez = 0;
        int uni = 0;
        
        if (m1.length() == 4) {
	        mil= Integer.parseInt(m1.substring(0,1));
	        cem= Integer.parseInt(m1.substring(1,2));
	        dez= Integer.parseInt(m1.substring(2,3));
	        uni= Integer.parseInt(m1.substring(3,4));
        } else {
        	System.out.println("Matricula errada!");
        }
        
        sum = mil*5 + cem*4 + dez *3 + uni*2; 
        String hexa = Integer.toHexString(sum%16).toUpperCase();
        String matC = mil + "" + cem + "" + dez + "" + uni +"-"+ hexa;
        
        System.out.println(matC);
        
		sc.close();
	}
}
