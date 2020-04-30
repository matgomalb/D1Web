package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class AtualizarNoticiaController
 */
@WebServlet("/AtualizarNoticiaController.do")
public class AtualizarNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		noticia = ns.carregar(id);
		
		out.print("<html><head>" + 
				  "<style> body {font-family: Arial, Helvetica, sans-serif;background-color: #778899;}" +
				  " input,textarea,button{width: 100%; padding: 12px; border: 1px solid #ccc;" +
				  " margin-top: 6px; margin-bottom: 16px; resize: vertical;}" +
				  "div{border-style: outset;background-color: White;}" +
				  "input[type=submit],button { background-color: #4169E1; color: white; padding: 12px 20px; border: none; cursor: pointer; }"
				+ "</style>" +
				  "<title>Noticia</title><body>");
		out.print("<br><div> <form action= ViewNoticiaController.do methodo=post>" +
				 "<label for='titulo'> Título </label>"+
				 "<input id='titulo' value=" + noticia.getTitulo() + ">" + 
				 "<label for='descricao'> Descrição </label>" +
				 "<input id='descricao' value=" + noticia.getDescricao() + ">" +
				 "<label for='descricao'> Texto </label>" +
				 "<textarea id='texto' style='height:170px'>" + noticia.getTexto()+ "</textarea>" +
				 "<input type='submit' value='Comentario'>" + 
				 "</form><form action= AtualizarNoticiaController.do methodo=post>" +
				 "<Button name='id' value="+ noticia.getId() + "> Atualizar </Button>" +
				 "</form></div>");
		out.print("</body></html>");
		
		//COLOCAR UMA PAGINA AQUI PARA PEGAR OS DADOS E ATUALIZAR
		String titulo = request.getParameter("");
		String descricao = request.getParameter("");
		String texto = request.getParameter("");
		
		Noticia noticiaAtual = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setDescricao(descricao);
		noticia.setTexto(texto);
		
		ns.atualizar(noticiaAtual);
	}
}