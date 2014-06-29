package edu.upeu.ventas.web.form;

public class CursoForm {

	private String id;
	private String nombre;
	private String nroCreditos;
	private String nroHoras;
	private String checked;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNroCreditos() {
		return nroCreditos;
	}

	public void setNroCreditos(String nroCreditos) {
		this.nroCreditos = nroCreditos;
	}

	public String getNroHoras() {
		return nroHoras;
	}

	public void setNroHoras(String nroHoras) {
		this.nroHoras = nroHoras;
	}

}
