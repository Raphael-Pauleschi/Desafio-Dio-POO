package bootcamp.view;

import java.util.Scanner;

import bootcamp.controller.BootcampController;
import bootcamp.controller.ConteudoController;
import bootcamp.controller.DevController;

public class View {
	DevController dc = new DevController();
	ConteudoController cc = new ConteudoController();
	BootcampController bc = new BootcampController();
	boolean rodando = true;
	Scanner input = new Scanner(System.in);

	// Default data
	public View() {
		cc.criarCurso("Java trilha", "Descricao curso", 10);
		cc.criarCurso("Paradgima orientado a Objeto", "Descricao curso", 90);
		cc.criarMentoria("Mentoria de java", "Mentoria de java");

		bc.criarBootcamp("Bootcamp java dev", "Descricao Boot Camp");
		bc.colocarConteudo("Bootcamp java dev", cc.acharConteudo("Java trilha"));
		bc.colocarConteudo("Bootcamp java dev", cc.acharConteudo("Paradgima orientado a Objeto"));
		bc.colocarConteudo("Bootcamp java dev", cc.acharConteudo("Mentoria de java"));

		dc.criarDev("ricardo");
		dc.criarDev("jeff");

		dc.inscreverBootcamp("ricardo", bc.acharBootcamp("Bootcamp java dev"));
		dc.progredir("ricardo");
		dc.progredir("jeff");
		dc.inscreverBootcamp("jeff", bc.acharBootcamp("Bootcamp java dev"));

	}

	public void paginaPrincipal() {
		int escolha;
		do {
			System.out.println("Sistema de gerenciamento de Bootcamp");
			System.out.println("1 - Gerenciar Devs");
			System.out.println("2 - Gerenciar Conteudos");
			System.out.println("3 - Gerenciar Bootcamps");
			System.out.println("4 - Sair");
			escolha = Integer.parseInt(input.next());
			switch (escolha) {
			case 1:
				gerenciarDevs();
				break;
			case 2:
				gerenciarConteudos();
				break;
			case 3:
				gerenciarBootcamps();
				break;
			case 4:
				sair();
				break;
			default:
				System.err.println("Valor invalido");
			}
		} while (rodando);
		input.close();

	}

	public void gerenciarBootcamps() {
		boolean outroRodando = true;
		String nome;
		String descricao;
		String conteudo;
		int escolha;
		do {
			System.out.println("\nGerenciar Bootcamp");
			System.out.println("1 - Cadastrar bootcamp");
			System.out.println("2 - Listar bootcamp");
			System.out.println("3 - Devs incritos no bootcamp");
			System.out.println("4 - Consultar Bootcamp");
			System.out.println("5 - Inserir conteudo no bootcamp");
			System.out.println("6 - Voltar a principal");
			System.out.println("7 - Sair");
			escolha = Integer.parseInt(input.nextLine());
			switch (escolha) {
			case 1:
				System.out.println("Entre com o nome do bootcamp:");
				nome = input.nextLine();
				System.out.println("Entre com a descricao do bootcamp:");
				descricao = input.nextLine();
				bc.criarBootcamp(nome, descricao);
				break;
			case 2:
				bc.listarTodosBootcamp();
				break;
			case 3:
				System.out.println("Entre com o nome do bootcamp:");
				nome = input.nextLine();
				bc.devsBootcamp(nome);
				break;
			case 4:
				System.out.println("Entre com o nome do bootcamp:");
				nome = input.nextLine();
				bc.conteudosBootcamp(nome);
				break;
			case 5:
				System.out.println("Entre com o nome do bootcamp:");
				nome = input.nextLine();
				System.out.println("Entre com o nome do conteudo:");
				conteudo = input.nextLine();
				bc.colocarConteudo(nome, cc.acharConteudo(conteudo));
				break;
			case 6:
				outroRodando = false;
				sair();
				break;
			case 7:
				outroRodando = false;
				break;
			default:
				System.err.println("Valor invalido");
			}
		} while (outroRodando);
	}

	public void gerenciarDevs() {
		boolean outroRodando = true;
		String nome;
		String bootcamp;
		int escolha;
		do {
			System.out.println("\nGerenciar Devs");
			System.out.println("1 - Cadastrar Dev");
			System.out.println("2 - Listar Devs");
			System.out.println("3 - Inscrever Dev em bootcamp");
			System.out.println("4 - Consultar Dev");
			System.out.println("5 - Progredir cursos do Dev");
			System.out.println("6 - Voltar a principal");
			System.out.println("7 - Sair");
			escolha = Integer.parseInt(input.nextLine());
			switch (escolha) {
			case 1:
				System.out.println("Entre com o nome do dev: ");
				nome = input.nextLine();
				dc.criarDev(nome);
				break;
			case 2:
				dc.listarTodosDevs();
				break;
			case 3:
				System.out.println("Entre com o nome do dev: ");
				nome = input.nextLine();
				System.out.println("Entre com o nome do bootcamp: ");
				bootcamp = input.nextLine();
				dc.inscreverBootcamp(nome, bc.acharBootcamp(bootcamp));
				break;
			case 4:
				System.out.println("Entre com o nome do dev: ");
				nome = input.nextLine();
				dc.dadosDev(nome);
				break;
			case 5:
				System.out.println("Entre com o nome do dev: ");
				nome = input.nextLine();
				dc.progredir(nome);
				break;
			case 6:
				outroRodando = false;
				sair();
				break;
			case 7:
				outroRodando = false;
				break;
			default:
				System.err.println("Valor invalido");
			}
		} while (outroRodando);
	}

	public void gerenciarConteudos() {
		boolean outroRodando = true;
		int escolha;
		String nome;
		String descricao;
		int cargaHoraria;
		do {
			System.out.println("\nGerenciar Conteudo");
			System.out.println("1 - Cadastrar curso");
			System.out.println("2 - Cadastrar mentoria");
			System.out.println("3 - Listar conteudos");
			System.out.println("4 - Voltar a principal");
			System.out.println("5 - Sair");
			escolha = Integer.parseInt(input.nextLine());
			switch (escolha) {
			case 1:
				System.out.println("Entre com o titulo do curso:");
				nome = input.next();
				System.out.println("Entre com a descricao do curso:");
				descricao = input.next();
				System.out.println("Entre com a carga horaria (em horas) do curso: ");
				cargaHoraria = Integer.parseInt(input.nextLine());
				cc.criarCurso(nome, descricao, cargaHoraria);
				break;
			case 2:
				System.out.println("Entre com o titulo da mentoria:");
				nome = input.next();
				System.out.println("Entre com a descricao da mentoria:");
				descricao = input.next();
				cc.criarMentoria(nome, descricao);
				break;
			case 3:
				cc.listarTodosConteudo();
				break;
			case 4:
				outroRodando = false;
				sair();
				break;
			case 5:
				outroRodando = false;
				break;
			}
		} while (outroRodando);
	}

	public void sair() {
		System.out.println("Sistema encerrado");
		rodando = false;
	}
}
