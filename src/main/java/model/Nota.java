package model;

import com.google.gson.annotations.SerializedName;

public class Nota {
	@SerializedName("id")
	private int id;

	@SerializedName("value")
	private String valor;

	@SerializedName("created_at")
	private String creado;

	@SerializedName("updated_at")
	private String actualizado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCreado() {
		return creado;
	}

	public void setCreado(String creado) {
		this.creado = creado;
	}

	public String getActualizado() {
		return actualizado;
	}

	public void setActualizado(String actualizado) {
		this.actualizado = actualizado;
	}

}
