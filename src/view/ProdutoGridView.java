package view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.IProdutoService;
import model.Produto;

@SuppressWarnings("serial")
@SessionScoped
@Named("produtoCtrl")
	public class ProdutoGridView implements Serializable {
		private List<Produto> produto;
       
		public List<Produto> getProduto() {
			return produto;
		}

		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}

		public IProdutoService getService() {
			return service;
		}

		public void setService(IProdutoService service) {
			this.service = service;
		}

		@Inject
        private IProdutoService service;
       
        @PostConstruct
	    public void init() {
//			System.out.println("a"+user.getIdUsuario());

	       produto = service.ListarProdutos();
	       System.out.println("Pegando todos os produtos VIWEW"+produto.size());
	    }
	}

