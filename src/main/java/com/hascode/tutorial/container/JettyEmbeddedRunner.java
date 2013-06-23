package com.hascode.tutorial.container;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.hascode.tutorial.servlet.DatePrintServlet;

public class JettyEmbeddedRunner {
	public void startServer() {
		try {
			Server server = new Server();
			ServerConnector c = new ServerConnector(server);
			c.setIdleTimeout(1000);
			c.setAcceptQueueSize(10);
			c.setPort(8080);
			ServletContextHandler handler = new ServletContextHandler(server,
					"/app", true, false);
			ServletHolder servletHolder = new ServletHolder(
					DatePrintServlet.class);
			handler.addServlet(servletHolder, "/date");
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
