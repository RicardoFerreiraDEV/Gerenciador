package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Empresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
						
		    ListaEmpresas acao = new ListaEmpresas();
		    acao.executa(request, response);
			
			Banco banco = new Banco();
			List<Empresa> lista = banco.getEmpresas();

			request.setAttribute("empresas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
			rd.forward(request, response);
		}

		else if (paramAcao.equals("RemoveEmpresa")) {			
			
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(request, response);

		}

		else if (paramAcao.equals("MostrarEmpresa")) {
			
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
			
		}

	}

}
