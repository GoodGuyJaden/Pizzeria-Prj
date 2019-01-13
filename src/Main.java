import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	private static Scanner sc = new Scanner(System.in);
	private static Menu m = new Menu();
	
	public static void main(String[] args) 
	{
		creaMenu();
		menu_avvio();
	}
	
	public static void menu_avvio()
	{
		String scelta_switch = "";
		
		while(!scelta_switch.equals("9"))
		{
			System.out.println("Menu: seleziona la voce che desideri con il numero correlato\n"+
							   "0) Visualizzare il menu\n" +
							   "1) Inserisci nuova pizza\n" + 
							   "2) Trova pizze senza ingrediente\n" + 
							   "3) Per trovare pizze che costano più dell'importo inserito\n" + 
							   "4) Trova pizza tramite nome\n" +
							   "5) Conta pizze super\n" +
							   "6) Per sapere la pizza che costa meno\n" +
							   "7) Per uscire\n");
			
			scelta_switch = sc.nextLine();
			
			switch (scelta_switch) 
			{
				case "0":			System.out.println(m);
									break;
									
				case "1": 			m.addNewPizza(creaPizza());
									System.out.println("Pizza aggiunta al menu");
									break;
							
	 			case "2":			System.out.println("Inserisci l'ingrediente che non vuoi");
	 								System.out.println(m.trovaPizzeSenzaIng(sc.nextLine()));
									break;
							
				case "3":			try
									{
										System.out.println("Inserisci l'importo");
										System.out.println(m.pizzeCostose(sc.nextFloat()));
										sc.nextLine();
					
									}catch(InputMismatchException e)
									{
										System.out.println("Devi inserire solo numeri grazie.");
										sc.nextLine();
									}
									
									break;
							
				case "4":			System.out.println("Inserisci il nome della pizza da cercare");
									System.out.println(m.trovaPizza(sc.nextLine()));
									break;
							
				case "5":			System.out.println("Le pizze Super nel menu sono: " + m.contaSuperPizze());
									break;
				
				case "6":			System.out.println(m.pizzaEconomica());
									break;
									
				case "7":			System.out.println("\nArrivederci.");
									break;
				
				default:			System.out.println("\nSi prega di inserire soltanto le opzioni valide\n");
									break;
			}
		}
	}
	
	public static void creaMenu()
	{
		String [] nomi = {"margherita", "marinara", "diavola", "boscaiola", "prosciutto e funghi", "tedesca", "quattro formaggi", "napoletana", "capricciosa", "caprese"};
		String [] ing = {"pomodoro", "mozzarella", "salame piccante", "origano", "olio", "aglio", "acciughe", "capperi", "olive", "funghi", 
						 "prosciutto cotto", "wurstel", "carciofi", "basilico", "gorgonzola", "scamorza", "grana", "bufala", "salsiccia", 
						 "friarielli", "prosciutto crudo"};
		ArrayList<String> ingredienti = new ArrayList<String>();
		Pizza p;
		int selezione = 0;
		
		for(int i = 0; i < nomi.length; i++)
		{
			for(int j = (int)(Math.random()*4); j < 10; j++)
			{
				selezione = (int)(Math.random()*ing.length);
				if(ingredienti.contains(ing[selezione]))
				{
					j--;
				}
				else
				{
					ingredienti.add(ing[selezione]);
				}
			}
			//System.out.println(ingredienti);    //boh non capisco
			p = new Pizza(nomi[i].toUpperCase(), ingredienti, (float)(Math.random()*15+5));
			m.addNewPizza(p);
			ingredienti.clear();
		}
		
	}
	
	public static Pizza creaPizza()
	{
		String scelta = "";
		String nome = "";
		String ingrediente = "";
		ArrayList<String> ing = new ArrayList<String>();
		float prezzo = 0;
		Pizza p;
		
		do
		{
			System.out.println("Inserisci il nome di questa pizza");
			nome = sc.nextLine().toUpperCase();
			
		}while(m.checkNome(nome));
		
		while(!scelta.equals("1") && !scelta.equals("2"))
		{
			System.out.println("1)Normale\n2)SuperPizza\n");
			scelta = sc.nextLine();
		}
		
		if(scelta.equals("1"))
		{
			for(int i = 0;i<10;i++)
			{
				System.out.println("Inserisci un ingrediente, altrimenti inserisci 'x' se hai finito. MAX 10 ingredienti");
				ingrediente = sc.nextLine();
				if(ingrediente.equalsIgnoreCase("x"))
				{
					i = 10;
				}
				else
				{
					if(ingrediente.toLowerCase().equals("ananas"))
					{
						System.out.println("Esci fuori da questo locale, non è il posto per te.");
						break;
					}
					else
					{
						ing.add(ingrediente);
					}
				}
			}
		}
		else
		{
			for(int i = 0;i<20;i++)
			{
				System.out.println("Inserisci un ingrediente, altrimenti inserisci 'x' se hai finito. MAX 20 ingredienti");
				ingrediente = sc.nextLine();
				if(ingrediente.equalsIgnoreCase("x"))
				{
					i = 20;
				}
				else
				{
					if(ingrediente.toLowerCase().equals("ananas"))
					{
						System.out.println("Esci fuori da questo locale, non è il posto per te.");
						break;
					}
					else
					{
						ing.add(ingrediente);
					}
				}
				
			}
		}
		
		prezzo =(float) (ing.size()*1.50);
		
		if(scelta.equals("0"))
		{
			p = new Pizza(nome, ing, prezzo);
		}
		else
		{
			p = new PizzaSuper(nome, ing, prezzo);
		}
		
		return p;
	}


}
