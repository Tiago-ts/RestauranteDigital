package model;

public class FuncionarioService implements IFuncionarioService{
	  private FuncionarioDAO funcionarioDAO =null;
	    public FuncionarioService(){
	        this. funcionarioDAO = new FuncionarioDAO();
	    }
	    public void Cadastrar(Funcionario funcionario){
	        try{
	        this. funcionarioDAO.salvarFuncionario(funcionario);
	        System.out.println("Funcionario Salvo com sucesso!");
	    } catch (Exception e) {
	        System.out.println("Erro:"+e);
	    }
	                        
	    }
}
