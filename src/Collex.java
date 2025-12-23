import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import myinputs.Ler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Collex {
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to Collex, your organization app!");
		System.out.print("Menu - Choose an option: \n");
		int opt = 0;
		do {
			System.out.print("1-Login \n");
			System.out.print("2- \n");
			System.out.print("3- \n");
			System.out.print("4- \n");
			System.out.print("5- \n");
			System.out.print("6-Exit \n");
			opt = Ler.umInt();
			switch(opt) {
			case 1:
				System.out.print("Menu - Choose a category of items: \n");
				int optC = 0;
				do { 
					System.out.print(" 1- Figuras \n");
					System.out.print(" 2- Posters \n");
					System.out.print(" 3- Livros \n");
					System.out.print(" 4- Moedas \n");
					System.out.print(" 5- Bandas desenhadas \n");
					System.out.print(" 6- Camisolas \n");
					System.out.print(" 7- Back to menu \n");
					System.out.print(" 8- Exit \n");
					optC= Ler.umInt();
					switch(optC) {
					case 1:
						System.out.println("Chosen Category: FIGURAS!");
						int optF = 0;
						do {
							System.out.print(" 1-Figuras de Ação \n");
							System.out.print(" 2-Figuras Funko Pop \n");
							System.out.print(" 3-Estatuetas \n");
							System.out.print(" 4-Go back to menu \n");
							System.out.print(" 5-Exit \n");
							optF= Ler.umInt();
							switch(optF) {
							case 1:
								
							
							}
							
						}
					}
						
					
										
				
				}
				
			}
			
			
		}
	}

}
