package ejercicioHabitacion07;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public enum PolarEnum {
	North, East, South, West;

	public static List<PolarEnum> getLeftPolarEnum(Set<PolarEnum> drawnPolar) {
		return Arrays.asList(PolarEnum.values()).stream().filter((polar) -> {
			return !drawnPolar.contains(polar);
		}).collect(Collectors.toList());
	}

	public static PolarEnum getOppositePolar(PolarEnum polarEnum) {
		List<PolarEnum> asList = Arrays.asList(PolarEnum.values());
		int index = (asList.indexOf(polarEnum)+2)%4;
		return asList.get(index);
	}

	private static PolarEnum getRandomPolarEnum(List<PolarEnum> polars) {
		return polars.get(new Random().nextInt(polars.size()));
	}

	public static PolarEnum getRandomPolarEnum() {
		PolarEnum[] values = PolarEnum.values();
		return values[new Random().nextInt(values.length)];
	}

	public static PolarEnum GetRandomLeftPolarEnum(Set<PolarEnum> polarEnums) {
		return PolarEnum.getRandomPolarEnum(PolarEnum.getLeftPolarEnum(polarEnums));
	}
}
