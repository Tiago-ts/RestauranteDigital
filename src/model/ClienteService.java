package model;

import javax.ejb.Stateless;

@Stateless
public class ClienteService implements IClienteService {

	 private ClienteDAO clienteDAO =null;
	    public ClienteService(){
	        this.clienteDAO = new ClienteDAO();
	    }
	    @Override
	    public void Cadastrar(Cliente cliente){
	        try{
	        this.clienteDAO.saveCliente(cliente);
	        System.out.println("Cliente Salva com sucesso!");
	    } catch (Exception e) {
	        System.out.println("Erro:"+e);
	    }
	                        
	    }
	  
		@Override
		public void reset(String Nome, int cpf) {
			// TODO Auto-generated method stub
			Nome = null;
			cpf = 0;
			
		}
}
