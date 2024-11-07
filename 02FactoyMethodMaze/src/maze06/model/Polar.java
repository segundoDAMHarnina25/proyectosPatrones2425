package maze06.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public enum Polar {
	North, East, South, West;

	public static Polar getOppositePolar(Polar polar) {
		switch (polar) {
		case North:
			return South;
		case South:
			return North;
		case West:
			return East;
		case East:
			return West;
		default:
			return North;
		}
	}
	
	public static List<Polar> getLeftPolarEnum(Set<Polar> drawnPolar) {
		return Arrays.asList(Polar.values()).stream().filter((polar) -> {
			return !drawnPolar.contains(polar);
		}).collect(Collectors.toList());
	}
	
	public static Polar getRandomPolar(Polar... drawnPolar) {
		return  getRandomPolar(Set.of(drawnPolar));
	}
	public static Polar getRandomPolar(Set<Polar> drawnPolar) {
		List<Polar> leftPolarEnum = getLeftPolarEnum(drawnPolar);
		return leftPolarEnum.get(new Random().nextInt(leftPolarEnum.size()));
	}
}
