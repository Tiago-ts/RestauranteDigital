package model;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EnderecoService implements IEnderecoService {

	@Inject
	 private EnderecoDAO enderecoDAO;
	    
	    public void Cadastrar(Endereco endereco){
	        try{
	        this.enderecoDAO.salvarEndereco(endereco);
	        System.out.println("Endereco Salvo com sucesso!");
	    } catch (Exception e) {
	        System.out.println("Erro:"+e);
	    }
	                        
	    }
}
