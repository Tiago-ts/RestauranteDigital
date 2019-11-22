package model;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente(null, 0);
		
		cliente.setCpf(123);
		cliente.setIdCliente(1);
		
		cliente.setNome("mario");
		
		System.out.println(cliente.getNome());
	}
	}
