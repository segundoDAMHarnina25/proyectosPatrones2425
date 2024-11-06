package publisherGeoPoint04;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class GPSSubscriber implements Subscriber<GeographicalPoint> {

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
		//Aqui le pido al publisher que puedo recibir x elementos
		this.subscription.request(10);
	}

	@Override
	public void onNext(GeographicalPoint item) {
		System.out.println(item.toString());
		//Al volver a pedir 1 el publisher volvera a pedir 1
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}
	
}
