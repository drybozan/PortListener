package com.STM.PortListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortListenerApplication {

	public static void main(String[] args) {

		SpringApplication.run(PortListenerApplication.class, args);
		UDPServer udpServer = new UDPServer();
		udpServer.startServer();
	}

}
