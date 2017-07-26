package consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import common.Email;

@Component
class Consumer {

	@JmsListener(destination = "mailbox")
	void receive(Email email) {
		System.out.println("Received <" + email + ">");
	}
}
