package com.example.Mango_Restaurant.Repository;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Mango_Restaurant.Model.ItemLine;

@Repository
public class ItemLineDAOimpl implements ItemLineDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public ItemLine get(int id) {
		Session session = entityManager.unwrap(Session.class);
		ItemLine item = session.get(ItemLine.class, id);
		
		return item;
	}

}

