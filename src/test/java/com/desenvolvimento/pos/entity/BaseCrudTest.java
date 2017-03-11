package com.desenvolvimento.pos.entity;

import com.desenvolvimento.pos.util.BaseJPATest;

public class BaseCrudTest<E> extends BaseJPATest{

	/**
	 * Método responsável por salvar entidade.
	 * 
	 * @param entidade
	 */
	public void salvar(E entidade) {
		begin();
		getEm().persist(entidade);
		commit();
	}
	

	/**
	 * Método responsável por realizar begin.
	 */
	public void begin() {
		if(!getEm().getTransaction().isActive()){
			getEm().getTransaction().begin();
		}
	}

	/**
	 * Método responsável por realizar commit.
	 */
	public void commit() {
		begin();
		getEm().getTransaction().commit();
	}
}
