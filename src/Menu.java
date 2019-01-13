import java.util.ArrayList;

public class Menu 
{
	private ArrayList<Pizza> menu = new ArrayList<Pizza>();
	
	public boolean addNewPizza(Pizza p)
	{		
		menu.add(p);
		return true;
	}
	
	public boolean checkNome(String nome)  //controllo il nome
	{
		for(Pizza p_check:menu)
		{
			if(p_check.getNome().equalsIgnoreCase(nome))
			{
				System.out.println("Esiste già una pizza con questo nome\n");
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Pizza> trovaPizzeSenzaIng(String ingrediente)
	{
		ArrayList<Pizza> pizzeSenzaIng = new ArrayList<Pizza>();
		
		for(Pizza p:menu)
		{
			if(!(p.getIngredienti().contains(ingrediente)))
			{
				pizzeSenzaIng.add(p);
			}
		}
		
		return pizzeSenzaIng;
	}
	
	public ArrayList<Pizza> pizzeCostose(float prezzo)
	{
		ArrayList<Pizza> pizzeCostose = new ArrayList<Pizza>();
		
		for(Pizza p:menu)
		{
			if(p.getPrezzo() > prezzo)
			{
				pizzeCostose.add(p);
			}
		}
		
		return pizzeCostose;
	}
	
	public ArrayList<String> trovaPizza(String nome)
	{		
		for(Pizza p:menu)
		{
			if(p.getNome().equalsIgnoreCase(nome))
			{
				return p.getIngredienti();
			}
		}
		System.out.println("Non ci sono pizze con questo nome");
		return null;
	}

	public Pizza pizzaEconomica()
	{
		float min = 1000;
		Pizza p = null;
		
		for(Pizza p1:menu)
		{
			if(p1.getPrezzo() < min)
			{
				min = p1.getPrezzo();
				p = p1;
			}
		}
		
		return p;
	}

	public int contaSuperPizze()
	{
		int conta = 0;
		
		for(Pizza p:menu)
		{
			if(p.getSize() == Pizza.Size.SUPER)
			{
				conta++;
			}
		}
		
		return conta;
	}
	
	@Override
	public String toString()
	{
		String text = "";
		for(Pizza p: menu)
		{
			text += p.toString() + "\n";
		}
		return text;
	}
	
	
	
}
