package com.hascode.tutorial.container;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.hascode.tutorial.servlet.DatePrintServlet;

public class TomcatEmbeddedRunner {
	public void startServer() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		File base = new File(System.getProperty("java.io.tmpdir"));
		Context rootCtx = tomcat.addContext("/app", base.getAbsolutePath());
		Tomcat.addServlet(rootCtx, "dateServlet", new DatePrintServlet());
		rootCtx.addServletMapping("/date", "dateServlet");
		tomcat.start();
		tomcat.getServer().await();
	}
}
