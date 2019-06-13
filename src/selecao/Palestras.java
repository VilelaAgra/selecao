package selecao;

import java.time.LocalTime;
import java.util.ArrayList;

public class Palestras {
	
	private int almocoA;
	private int almocoB;
	private int finalA;
	private int finalB;
	
	private ArrayList<LocalTime> horario = new ArrayList<LocalTime>();
	private ArrayList<String> temas = new ArrayList<String>();
	private ArrayList<Integer> duracao = new ArrayList<Integer>();
	
	public int getAlmocoA() {
		return almocoA;
	}
	public void setAlmocoA(int almocoA) {
		this.almocoA = almocoA;
	}
	public int getAlmocoB() {
		return almocoB;
	}
	public void setAlmocoB(int almocoB) {
		this.almocoB = almocoB;
	}
	public int getFinalA() {
		return finalA;
	}
	public void setFinalA(int finalA) {
		this.finalA = finalA;
	}
	public int getFinalB() {
		return finalB;
	}
	public void setFinalB(int finalB) {
		this.finalB = finalB;
	}
	public ArrayList<LocalTime> getHorario() {
		return horario;
	}
	public void setHorario(ArrayList<LocalTime> horario) {
		this.horario = horario;
	}
	public ArrayList<String> getTemas() {
		return temas;
	}
	public void setTemas(ArrayList<String> temas) {
		this.temas = temas;
	}
	public ArrayList<Integer> getDuracao() {
		return duracao;
	}
	public void setDuracao(ArrayList<Integer> duracao) {
		this.duracao = duracao;
	}
	

	
	
	}

