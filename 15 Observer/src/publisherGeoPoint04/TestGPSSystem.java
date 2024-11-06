package publisherGeoPoint04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class TestGPSSystem {

	@Test
	void test() throws InterruptedException {
		GpsService gpsService=new GpsService();
		ExecutorService  executorService= Executors.newCachedThreadPool();
		executorService.execute(gpsService);
		GPSSubscriber subscriber=new GPSSubscriber();
		gpsService.subscribe(subscriber);
		executorService.awaitTermination(1,TimeUnit.MINUTES);
		executorService.shutdown();
	}

}
