package model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estudiante {
	@SerializedName("code")
	private int legajo;

	@SerializedName("first_name")
	private String nombre;

	@SerializedName("last_name")
	private String apellido;

	@SerializedName("github_user")
	private String usuarioGithub;

	@Expose(serialize = false, deserialize = true)
	@SerializedName("assignments")
	private List<Asignacion> asignaciones;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}

	public void setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
	}

}
