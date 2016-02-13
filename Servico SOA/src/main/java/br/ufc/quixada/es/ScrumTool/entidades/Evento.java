package br.ufc.quixada.es.ScrumTool.entidades;

public class Evento {

	private String operacao;
	private String banco;
	private Object data;

	public Evento(String operacao, String banco, Object data) {
		this.operacao = operacao;
		this.banco = banco;
		this.data = data;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
