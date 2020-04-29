package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class DeletarNoticiaController
 */
@WebServlet("/DeletarNoticiaController.do")
public class DeletarNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
		System.out.println("POST DO DELETAR");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Id Delete: " + id);
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		NoticiaService ns = new NoticiaService();
		ns.excluir(noticia);
		//ns.excluir(noticia);
		
		
		PrintWriter out = response.getWriter();
		out.print("Essa é a noticia: " + noticia.toString());
		//ns.excluir(noticia);
		out.print("Noticia Apagada com Sucesso. Noticias: " + ns.carregarTudo());
		
		RequestDispatcher view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
}
}