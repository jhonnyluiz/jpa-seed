package com.desenvolvimento.pos.util;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

public class BaseJPATest {

	private EntityManager em;

	@Before
	public void instanciarEntityManager() {
		em = JPAUtil.INSTANCE.getEntityManager();
	}
	
	@After
	public void fecharEntityManager() {
		if(em.isOpen()) {
			em.close();
		}
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
}
