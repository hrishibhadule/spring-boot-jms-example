
---


The hell is this?
-------------

A simple Spring Boot project that succinctly demonstrates 
Spring JMS (based on the [official tutorial][1]).

It contains 2 apps : one for consuming messages (via MDPs or Message Driven Pojos) and one for producing them (via JmsTemplate).
For demonstration purposes, it connects to an ActiveMQ standalone server.


How can I run the examples?
-------------

You need to have a running ActiveMQ server (the examples connect to `tcp://localhost:61616`).
After that, run the consumer app and then the producer app with the following command : 
`java -jar target/spring-boot-jms-example-v1.jar [consumer|producer]`




What now?
-------------
Nothing really, it's just a demo / memo :D


[1]: https://spring.io/guides/gs/messaging-jms/