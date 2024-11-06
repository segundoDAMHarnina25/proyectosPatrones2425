 package publisherteoria03;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;
//https://picodotdev.github.io/blog-bitix/2019/03/ejemplo-de-reactive-streams-en-java/
public class MyProPub2 {

	private static class PrintSubscriber implements Flow.Subscriber<Integer> {

		private Flow.Subscription subscription;

		int elements = 3;
		int amount = 0;

		@Override
		public void onSubscribe(Flow.Subscription subscription) {
			this.subscription = subscription;
			subscription.request(6);
		}

		//backpressure en modo pull
		@Override
		public void onNext(Integer item) {
			System.out.println("Received item: " + item);
//			if (++amount <= elements)
////				subscription.cancel();
//			subscription.request(1);
			Sleeper.sleep(500);
		}

		@Override
		public void onError(Throwable error) {
			error.printStackTrace();
		}

		@Override
		public void onComplete() {
			System.out.println("PrintSubscriber completed");
		}
	}

	private static class Sleeper {
		private static void sleep(int time) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
		Flow.Subscriber<Integer> subscriber = new PrintSubscriber();
		publisher.subscribe(subscriber);

		IntStream.range(0, 5).forEach(it -> {
			publisher.submit(it);
			Sleeper.sleep(500);
		});

		publisher.close();
	}
}
