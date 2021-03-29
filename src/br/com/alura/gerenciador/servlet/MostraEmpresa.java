package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Empresa;

public class MostraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mosntrando Dados Empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaId(id);
		
		System.out.println(empresa.getId());
		System.out.println(empresa.getNome());
		System.out.println(empresa.getDataAbertura());
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
		
	}

}
