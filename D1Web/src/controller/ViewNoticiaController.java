package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class ViewNoticiaController
 */
@WebServlet("/ViewNoticiaController.do")
public class ViewNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("id" + request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		Comentario comentario = new Comentario();
		ComentarioService cs = new ComentarioService();
		
		noticia = ns.carregar(id);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head>" +
					"<style> body {font-family: Arial, Helvetica, sans-serif;}" +
					" input,textarea,button{width: 100%; padding: 12px; border: 1px solid #ccc;" +
					" margin-top: 6px; margin-bottom: 16px; resize: vertical;}" +
					" input[type=submit],button { background-color: #4169E1; color: white; padding: 12px 20px; border: none; cursor: pointer; } "
					+ "</style>"
					+ "<title>Noticia</title>");
		
		out.println("<h2>Real News </h2>" +
				 	"<h3> Titulo: " + noticia.getTitulo() + "</h3>" +
				 	"<h3> Noticia:</h3>" +
					"<textarea> " + noticia.getTexto() + "</textarea>");
		
		out.println("<h1>Comentários</h1>");
		
		for(Comentario comm : cs.carregar(noticia)) {
			out.print("<br><div> <form action= ViewNoticiaController.do methodo=post>" +
					 "<label for='titulo'> Nome </label>"+
					 "<input id='titulo' value=" + comm.getNome() + ">" +
					 "<label for='descricao'> Texto </label>" +
					 "<textarea id='texto' style='height:100px'>" + comm.getTexto()+ "</textarea>" +
					 "</div>");		
		}
		out.println("<h2>Comentários</h2>" +
				"<form action=InserirComentarioController.do method=post>" +
				"<label for='fname'>Nome:</label>" +
				"<input id='fname' name='firstname' placeholder='Seu Nome...'/>"+
				"<label for='subject'>Comentário:</label>"+
				"<textarea id='subject' name='subject' placeholder='Escreva alguma coisa..' style='height:170px'></textarea>"
				+ "<Button name='noticiaId' value=" + id + "> Comentar </button>");
		out.println("</body></html>");
	}
}