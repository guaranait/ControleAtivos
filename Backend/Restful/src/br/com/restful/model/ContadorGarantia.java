package br.com.restful.model;

public class ContadorGarantia {
	private long aVencer = 0;
	private long vencida = 0;
	private long venceMes = 0;
	
	public ContadorGarantia() {
		super();
	}

	public ContadorGarantia(long aVencer, long vencida, long venceMes) {
		super();
		this.aVencer = aVencer;
		this.vencida = vencida;
		this.venceMes = venceMes;
	}

	public long getaVencer() {
		return aVencer;
	}

	public void setaVencer(long aVencer) {
		this.aVencer = aVencer;
	}

	public long getVencida() {
		return vencida;
	}

	public void setVencida(long vencida) {
		this.vencida = vencida;
	}

	public long getVenceMes() {
		return venceMes;
	}

	public void setVenceMes(long venceMes) {
		this.venceMes = venceMes;
	}
	
	
}
