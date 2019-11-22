package model;

public class ReservaService implements IReservaService{

	private ReservaDAO reservaDAO = null;
	public ReservaService() {
		this.reservaDAO = new ReservaDAO();
	}


	public void Cadastrar(Reserva reserva) {
	try {
		reservaDAO.salvarReserva(reserva);
		System.out.println("REserva feita!");
	}catch (Exception e) {
		System.out.println("erro : "+e);
	}
	
	}
}
