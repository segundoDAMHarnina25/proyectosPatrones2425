package ejercicio02;

public class NutritionFacts {

	// obligatorias
	private  int servingSize;
	private  int servings;
	// opcionales
	private  int calories;
	private  int fat;

	private NutritionFacts(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
	}
	
	public static class Builder{
		private  int servingSize;
		private  int servings;
		// opcionales
		private  int calories;
		private  int fat;
		
		private Builder(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
			this.calories=0;
			this.fat=0;
		}
		
		public static Builder builder(int servingSize, int servings) {
			return new Builder(servingSize, servings); 
		}
		
		public Builder calories(int calories) {
			this.calories=calories;
			return this;
		}
		public Builder fat(int fat) {
			this.fat=fat;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}

	}

	public int getServingSize() {
		return servingSize;
	}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	
}
