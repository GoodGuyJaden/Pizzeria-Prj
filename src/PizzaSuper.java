import java.util.ArrayList;

public class PizzaSuper extends Pizza
{
	public PizzaSuper(String nome, ArrayList<String> ingredienti, float prezzo)
	{
		super(nome, ingredienti, prezzo);
		super.setSizeSuper();
	}
}
