package ejercicio02;

public class NutritionFactsSingleton {

	// obligatorias
	private int servingSize;
	private int servings;
	// opcionales
	private int calories;
	private int fat;

	private NutritionFactsSingleton(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
	}

	public static class Builder {
		private int servingSize;
		private int servings;
		// opcionales
		private int calories = 0;
		private int fat = 0;
		public static Builder instance;

		private Builder(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public static Builder getInstance(int servingSize, int servings) {
			if (instance == null)
				instance = new Builder(servingSize, servings);
			return instance;
		}

		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}

		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}

		public NutritionFactsSingleton build() {
			return new NutritionFactsSingleton(this);
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
