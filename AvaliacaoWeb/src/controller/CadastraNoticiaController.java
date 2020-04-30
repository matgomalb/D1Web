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
 * Servlet implementation class CadastraNoticiaController
 */
@WebServlet("/CadastraNoticiaController.do")
public class CadastraNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST DO CADASTRO");;
		String nTitulo = request.getParameter("titulo");
		String nDescricao = request.getParameter("descricao");
		String nTexto = request.getParameter("texto");
		
		Noticia noticia = new Noticia();
		noticia.setId(0);
		noticia.setTitulo(nTitulo);
		noticia.setDescricao(nDescricao);
		noticia.setTexto(nTexto);
		System.out.println("noticia: " + noticia);
		
		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		
		RequestDispatcher view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
	}
}