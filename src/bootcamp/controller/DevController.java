package bootcamp.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import bootcamp.model.Bootcamp;
import bootcamp.model.Conteudo;
import bootcamp.model.Dev;

public class DevController {
	private Set<Dev> devSet = new HashSet<>();

	public DevController() {

	}

	public void criarDev(String nome) {
		Dev dev = new Dev();
		dev.setNome(nome);
		devSet.add(dev);
	}

	public void inscreverBootcamp(String nome, Bootcamp bootcamp) {
		Dev dev = acharDev(nome);
		dev.getConteudoInscrito().addAll(bootcamp.getConteudos());
		bootcamp.getDevsIncritos().add(dev);
	}

	public void progredir(String nome) {
		Dev dev = acharDev(nome);
		Optional<Conteudo> conteudo = dev.getConteudoInscrito().stream().findFirst();
		if (conteudo.isPresent()) {
			dev.getConteudoConcluido().add(conteudo.get());
			dev.getConteudoInscrito().remove(conteudo.get());
		} else {
			System.err.println("Não há matricula em nennum conteudo");
		}

	}

	public void dadosDev(String nome) {
		Dev dev = acharDev(nome);
		System.out.println("Informações do Dev " + dev.getNome() + ":");
		System.out.println("Exp adquirida: " + calcularXP(dev));
		System.out.println("Conteudos inscritos: " + dev.getConteudoInscrito());
		System.out.println("Conteudos concluidos: " + dev.getConteudoConcluido());
	
	}

	private double calcularXP(Dev dev) {	
		return dev.getConteudoConcluido().stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
	}

	public void listarTodosDevs() {
		System.out.println("\nListar todos os devs: ");
		for (Dev devAcha : devSet) {
			System.out.println(devAcha.getNome());
		}
	}

	// Arruma com exception
	public Dev acharDev(String nome) {

		for (Dev devAcha : devSet) {
			if (devAcha.getNome().equals(nome)) {
				return devAcha;
			}
			
		}

		return new Dev();
	}

}
