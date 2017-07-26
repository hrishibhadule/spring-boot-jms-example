package consumer;

import javax.jms.ConnectionFactory;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import common.MessageConverters;

/**
 * Kick-starts a simple jms infrastructure for receiving messages. <br />
 * Connects to an ActiveMQ standalone server. <br />
 * Uses @JmsListeners.
 * 
 * @author pjayes
 *
 */
@SpringBootApplication(scanBasePackages = { "consumer" })
// scan for @JmsListener
@EnableJms
public class ConsumerApp {

	ConnectionFactory connectionFactory() {
		ConnectionFactory connectionFactory = new PooledConnectionFactory("tcp://localhost:61616");
		return connectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setDestinationResolver(new DynamicDestinationResolver());
		factory.setMessageConverter(MessageConverters.defaultMessageConverter());
		factory.setConcurrency("3-10");
		return factory;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerApp.class, args);
	}
}
