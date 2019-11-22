package model;

public class MesaService implements IMesaService{

	
	public MesaDAO MesaDAO = null;
	public MesaService() {
		this.MesaDAO = new MesaDAO();
	}
	public void Cadastrar(Mesa mesa) {
		try {
			
			this.MesaDAO.salvarMesa(mesa);
			System.out.println("Mesa Salva com sucesso!");
		}catch (Exception e) {
			System.out.println("Erro:"+e);
		} 
		
	}
}
