import java.util.ArrayList;
import java.util.Scanner;

public class Pizza 
{
	protected enum Size{SMALL, SUPER};
	
	private String nome;
	private ArrayList<String> ingredienti = new ArrayList<String>();
	private float prezzo;
	private Size forma;
	
	public Pizza(String nome, ArrayList<String> ingredienti, float prezzo)
	{
		this.nome = nome;
		this.ingredienti = ingredienti;
		this.prezzo = prezzo;
		forma = Size.SMALL;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<String> getIngredienti() {
		return ingredienti;
	}
	
	public void setIngredienti(ArrayList<String> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public Size getSize()
	{
		return forma;
	}
	
	public void setSizeSuper()
	{
		forma = Size.SUPER;
	}
	
	@Override
	public String toString() 
	{
		return nome + "\t\t" + String.format("%.2f", prezzo) + "€\n " + ingredienti + "\n";
	}

	public static void main(String[] args) {
		String scelta = "";
		String nome = "";
		String ingrediente = "";
		ArrayList<String> ing = new ArrayList<String>();
		ArrayList<Pizza> pizze = new ArrayList<Pizza>();
		float prezzo = 0;
		Pizza p;
		Scanner sc = new Scanner(System.in);
		
		nome = sc.nextLine();
		
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
			for(int i = 0;i<20 || !ingrediente.toLowerCase().equals("x");i++)
			{
				System.out.println("Inserisci un ingrediente, altrimenti inserisci 'x' se hai finito. MAX 20 ingredienti");
				ingrediente = sc.nextLine();
				if(!ingrediente.toLowerCase().equals("x"))
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
		
		System.out.println(p);
	}

}
