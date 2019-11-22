package model;


import javax.ejb.Stateless;


import java.util.ArrayList;
import java.util.List;



@Stateless
public class ProdutoService implements IProdutoService
{
	
    private ProdutoDAO ProdutoDAO =null;
    public ProdutoService(){
        this.ProdutoDAO = new ProdutoDAO();
    }
    
    
    
    @Override
    public void Cadastrar(Produto Produto){
        try{
        this.ProdutoDAO.saveProduto(Produto);
        System.out.println("Produto Salva com sucesso!");
    } catch (Exception e) {
        System.out.println("Erro:"+e);
    }
                        
    }
   
   
	
	public List<Produto> ListarProdutos() {
		
        List<Produto> list = new ArrayList<>(); 
        list = ProdutoDAO.ListarProdutos();
        System.out.println("Pegando todos os produtos sERVICE"+list.size());
		
        return list;
    }
	public static void main(String[] args) {
		
		//System.out.println(p.ListarProdutos().size());
	}
   
}

