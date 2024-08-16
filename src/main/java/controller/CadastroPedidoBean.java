package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroPedidoBean {
	
	private List<Integer> items;
	
	
	public CadastroPedidoBean() {
		items = new ArrayList<Integer>();
		items.add(1);
	}


	public List<Integer> getItems() {
		return items;
	}


	
	
	
}
