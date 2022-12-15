package bootcamp.controller;

import java.util.HashSet;
import java.util.Set;

import bootcamp.model.Conteudo;
import bootcamp.model.Curso;
import bootcamp.model.Mentoria;

public class ConteudoController {
	private Set<Conteudo> listaConteudos = new HashSet<>();

	public void criarMentoria(String titulo, String descricao) {
		if (validaConteudo(titulo)) {
			Mentoria mentoria = new Mentoria();
			mentoria.setTitulo(titulo);
			mentoria.setDescricao(descricao);
			listaConteudos.add(mentoria);
		}
	}

	public void criarCurso(String titulo, String descricao, int cargaHoraria) {
		if (validaConteudo(titulo)) {
			Curso curso = new Curso();
			curso.setTitulo(titulo);
			curso.setDescricao(descricao);
			curso.setCargaHoraria(cargaHoraria);
			listaConteudos.add(curso);
		}
	}

	public boolean validaConteudo(String titulo) {
		for (Conteudo achaCont : listaConteudos) {
			if (achaCont.getTitulo() == titulo) {
				System.err.println("Já existe conteudo com esse titulo");
				return false;
			}
		}
		System.out.println("Conteudo criado! "+titulo);
		return true;
	}

	public void listarTodosConteudo() {
		System.out.println("\nTodos os conteudos: ");
		for (Conteudo achaCont : listaConteudos) {
			System.out.println(achaCont.getTitulo());
		}
	}
	
	public Conteudo acharConteudo(String titulo) {
		for (Conteudo achaCont : listaConteudos) {
			if (achaCont.getTitulo().equals(titulo))
				return achaCont;
		}

		return null;
	}

}
