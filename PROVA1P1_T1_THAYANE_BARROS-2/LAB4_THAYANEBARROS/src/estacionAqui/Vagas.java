package estacionAqui;

import java.util.Objects;

/**
 * Classe que representa uma vaga de estacionamento.
 * 
 * @author Thayane Barros - 121110604
 *
 */
public class Vagas {
	
	private String endereco;
	private int numeracao;
	private String link;
	private double area;
	private String status;
	private int statusOcupada;
	
	public Vagas(String endereco, double valorDaArea, int numeracao) {
		if(numeracao < 0 || numeracao > 99) {
			throw new IllegalArgumentException("ID Invalido");
		}
		
		this.endereco = endereco;
		this.area = valorDaArea;
		this.link = "https://";
		this.status = "LIVRE";
		this.numeracao = numeracao;
		this.statusOcupada = 0;
	}
	
	public Vagas(String endereco, String link, double valorDaArea, int numeracao) {
		if(numeracao < 0 || numeracao > 99) {
			throw new IllegalArgumentException("ID Invalido");
		}
		
		this.endereco = endereco;
		this.area = valorDaArea;
		this.link = link;
		this.status = "LIVRE";
		this.numeracao = numeracao;
		this.statusOcupada = 0;
	}

	public void mudarStatus() {
		if(this.status.equals("LIVRE")) {
			this.status = "OCUPADA";
			this.statusOcupada += 1;
		} else if(this.status.equals("OCUPADA")){
			this.status = "LIVRE";
		}
	}

	public double preco(int horas) {
		if(horas < 0) {
			throw new IllegalArgumentException("Quantidade de horas invalida");
		}
		
		double preco = (horas * 3) + (this.area * 0.1);
		double precoArredondado = (int)(preco*100);
		
		return precoArredondado / 100;
	}

	@Override
	public String toString() {
		return this.numeracao + " - " + this.endereco + " - " + this.link + " - " + this.status;

	}

	@Override
	public int hashCode() {
		return Objects.hash(area, endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vagas other = (Vagas) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area)
				&& Objects.equals(endereco, other.endereco);
	}

	public String getStatus() {
		return status;
	}

	public int getStatusOcupada() {
		return statusOcupada;
	}

}
