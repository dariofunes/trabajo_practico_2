package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private String codigo;
	private Mes mes;
	private Integer dia;
	private String detalle;
	
	public Efemeride() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "\nCodigo= " + codigo + "\nMes= " + mes + "\nDia= " + dia + "\nDetalle= " + detalle + "\n";
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Mes getMes() {
		return mes;
	}
	
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	public Integer getDia() {
		return dia;
	}
	
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}
