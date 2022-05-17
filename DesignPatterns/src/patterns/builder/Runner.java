package patterns.builder;

public class Runner {

	public static void main(String[] args) {
		RecipeBuilder recipeBuilder = new RecipeBuilder();
		PastryBuilder pastryBuilder = new PastryBuilder();
		Director director = new Director();
		
		Pastry pastry = null;
		Recipe recipe = null;
		
		director.constructDominican(pastryBuilder);
		pastry = pastryBuilder.getResult();
		System.out.println("Created pastry:\n" + pastry);
		
		director.constructHawaiian(pastryBuilder);
		pastry = pastryBuilder.getResult();
		System.out.println("Created pastry:\n" + pastry);
		
		director.constructDominican(recipeBuilder);
		recipe = recipeBuilder.getResult();
		System.out.println(recipe);
		
		director.constructHawaiian(recipeBuilder);
		recipe = recipeBuilder.getResult();
		System.out.println(recipe);
	}

}
