package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import service.NegocioException;

@ManagedBean
@RequestScoped
public class CadastroPedidoBean {
	
	private List<Integer> items;
	
	
	public CadastroPedidoBean() {
		items = new ArrayList<Integer>();
		items.add(1);
	}
	
	
	public void salvar() {
		throw new NegocioException("Pedido nao pode ser salvo");
	}


	public List<Integer> getItems() {
		return items;
	}


	
	
	
}
