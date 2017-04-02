package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Asignaciones {

	@SerializedName("assignments")
	private List<Asignacion> asignaciones;

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
