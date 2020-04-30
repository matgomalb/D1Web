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
 * Servlet implementation class MostrarNoticiasController
 */
@WebServlet("/MostrarNoticiasController.do")
public class MostrarNoticiasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST DO LISTAR NOTICIA");
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		PrintWriter out = response.getWriter();
		
		out.print("<html><head>" + 
				  "<style> body {font-family: Arial, Helvetica, sans-serif;background-color: #778899;}" +
				  " input,textarea,button{width: 100%; padding: 12px; border: 1px solid #ccc;" +
				  " margin-top: 6px; margin-bottom: 16px; resize: vertical;}" +
				  "div{border-style: outset;background-color: White;}" +
				  "input[type=submit],button { background-color: #4169E1; color: white; padding: 12px 20px; border: none; cursor: pointer; }"
				+ "</style>" +
				  "<title>Noticia</title><body>");
		
		for(Noticia noticia1 : ns.carregarTudo()) {
			System.out.println("NOTICIA: " + noticia1);
			noticia = noticia1;
			out.print("<br><div> <form action= ViewNoticiaController.do methodo=post>" +
					 "<label for='id'> ID </label>"+
					 "<input id='id' name='id' value="+ noticia.getId() + " readonly>" +
					 "<label for='titulo'> Título </label>"+
					 "<input id='titulo' value=" + noticia.getTitulo() + " readonly>" + 
					 "<label for='descricao'> Descrição </label>" +
					 "<input id='descricao' value=" + noticia.getDescricao() + " readonly>" +
					 "<label for='descricao'> Texto </label>" +
					 "<textarea readonly id='texto' style='height:170px'>" + noticia.getTexto()+ "</textarea>" +
					 "<input type='submit' value='Comentario'>" + 
					 "</form><form action= DeletarNoticiaController.do methodo=post>" +
					 "<Button name='id' value="+ noticia.getId() + "> Deletar </Button>" +
					 "</form></div>");
		}
		out.print("</body></html>");
	}
}