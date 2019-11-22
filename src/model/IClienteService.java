package model;

import javax.ejb.Local;
@Local
public interface IClienteService{
	
	  public void Cadastrar(Cliente cliente);
	  public void reset(String Nome, int cpf);
		

		

	
}
