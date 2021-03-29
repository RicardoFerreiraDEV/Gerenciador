package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/oi")
public class OiMundoServlet extends HttpServlet	 {

	private static final long serialVersionUID = 1L;
	
	public OiMundoServlet() {
		System.out.println("Criando Mundo Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 	
		@SuppressWarnings("unused")
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Primeiro Servlet");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}	
