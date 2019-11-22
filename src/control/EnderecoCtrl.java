package control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Endereco;
import model.IEnderecoService;
@SuppressWarnings("serial")
@Named("End")
@SessionScoped
public class EnderecoCtrl implements Serializable{

	
	@Inject
	private IEnderecoService servicoEnd;
	
	public IEnderecoService getServicoEnd() {
		return servicoEnd;
	}

	public void setServicoEnd(IEnderecoService servicoEnd) {
		this.servicoEnd = servicoEnd;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	private String cidade;
	private String logradouro;
	private String uf;
	private String cep;
	private Endereco end;
	
	public void cadastrarEndereco() {
		end.setCidade(cidade);
		end.setLogradouro(logradouro);
		end.setUF(uf);
		end.setCep(cep);
		servicoEnd.Cadastrar(end);
	}
	
	
}
