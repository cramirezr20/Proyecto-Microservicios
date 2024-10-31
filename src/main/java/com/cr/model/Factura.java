package com.cr.model;

public class Factura {
	public Factura(Long id, String clienteId, String monto, String fecha) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.monto = monto;
		this.fecha = fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	private Long id;
    private String clienteId;
    private String monto;
    private String fecha;
}
