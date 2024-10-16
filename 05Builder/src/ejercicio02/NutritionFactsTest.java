package ejercicio02;

import org.junit.jupiter.api.Test;

class NutritionFactsTest {

	@Test
	void test() {
		NutritionFacts nutritionFacts=
				 NutritionFacts.Builder.builder(3,4).calories(2).build();
		NutritionFactsSingleton nutritionFactsSingleton=
				 NutritionFactsSingleton.Builder.getInstance(3,4).calories(2).build();
		NutritionFactsSingleton nutritionFactsSingleton2=
				NutritionFactsSingleton.Builder.getInstance(3,4).fat(2).build();
		System.out.println();
	}

}
