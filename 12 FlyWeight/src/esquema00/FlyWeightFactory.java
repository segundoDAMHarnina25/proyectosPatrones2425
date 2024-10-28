package esquema00;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FlyWeightFactory {
public List<FlyWeight> cache;

public FlyWeightFactory() {
	super();
	cache=new ArrayList<>();
}
public FlyWeight getFlyWeight(String repeating) {
	Optional<FlyWeight> findFirst = cache.stream()
			.filter((fly)->{return fly.contains(repeating);})
			.findFirst();
	FlyWeight retorno=null;
	if(findFirst.isEmpty()) {
		retorno=new FlyWeight(repeating);
		cache.add(retorno);
	}else {
		retorno=findFirst.get();
	}
	return retorno;
}
}
