package com.verizon.sjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sjdbc.dao.ItemDAO;
import com.verizon.sjdbc.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemDAO.addItem(item);
	}

	@Override
	public void removeItem(int iCode) {
		// TODO Auto-generated method stub
		itemDAO.removeItem(iCode);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		itemDAO.updateItem(item);
	}

	@Override
	public Item getItem(int iCode) {
		// TODO Auto-generated method stub
		return itemDAO.getItem(iCode);
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemDAO.getItems();
	}

	@Override
	public boolean exists(int iCode) {
		// TODO Auto-generated method stub
		return itemDAO.getItem(iCode)!=null;
	}

}
