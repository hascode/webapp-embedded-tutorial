package com.hascode.tutorial.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/printdate")
public class DatePrintServlet {
	@GET
	public void handleGet(final HttpServletRequest req,
			final HttpServletResponse res) {
	}
}