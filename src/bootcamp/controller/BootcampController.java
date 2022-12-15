package bootcamp.controller;

import java.util.HashSet;
import java.util.Set;

import bootcamp.model.Bootcamp;
import bootcamp.model.Conteudo;
import bootcamp.model.Dev;

public class BootcampController {
	private Set<Bootcamp> bootcampsDisponiveis = new HashSet<>();
	public void criarBootcamp(String nome, String descricao) {
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome(nome);
		bootcamp.setDescricao(descricao);
		bootcampsDisponiveis.add(bootcamp);
	}
	
	public void colocarConteudo(String nome, Conteudo conteudo) {
		Bootcamp bootcamp = acharBootcamp(nome);
		bootcamp.getConteudos().add(conteudo);
		
	}
	public void devsBootcamp(String nome) {
		Bootcamp bootcamp = acharBootcamp(nome);
		System.out.println("Devs inscritos:");
		for(Dev devInscrito: bootcamp.getDevsIncritos())
		System.out.println(devInscrito.getNome());
	}
	
	public void conteudosBootcamp(String nome) {
		Bootcamp bootcamp = acharBootcamp(nome);
		System.out.println("Descricao: "+bootcamp.getDescricao());
		System.out.println("Conteudos: "+bootcamp.getConteudos());
		
	}
	
	public void listarTodosBootcamp() {
		System.out.println("\nTodos os bootcamps: ");
		for (Bootcamp achaBoot : bootcampsDisponiveis) {
			System.out.println(achaBoot.getNome());
		}
	}
	
	public Bootcamp acharBootcamp(String nome) {
		for (Bootcamp achaBoot : bootcampsDisponiveis) {
			if (achaBoot.getNome().equals(nome))
				return achaBoot;
		}

		return new Bootcamp();
	}
	
	
}
