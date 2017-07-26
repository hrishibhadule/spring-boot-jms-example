package boot;

import consumer.ConsumerApp;
import producer.ProducerApp;

public class AppStarter {

	public static void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage : ");
			System.out.println("java -jar target/spring-boot-jms-example-v1.jar [consumer|producer]");
			return;
		}

		if (args[0].equalsIgnoreCase("consumer")) {
			ConsumerApp.main(args);
			return;
		}

		if (args[0].equalsIgnoreCase("producer")) {
			ProducerApp.main(args);
			return;
		}
	}
}
