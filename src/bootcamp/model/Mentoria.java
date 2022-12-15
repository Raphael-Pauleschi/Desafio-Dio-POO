package bootcamp.model;

import java.time.LocalDate;

public class Mentoria extends Conteudo{
	private LocalDate cargaHoraria = LocalDate.now();

	public Mentoria() {}

	public LocalDate getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(LocalDate cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Mentoria [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", cargaHoraria=" + cargaHoraria + ", XP Adquirido "+calcularXP()+"]";
	}

	@Override
	public double calcularXP() {
		return XP_PADRAO + 20d;
	}

}
