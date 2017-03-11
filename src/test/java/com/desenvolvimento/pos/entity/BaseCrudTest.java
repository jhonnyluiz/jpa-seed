package com.desenvolvimento.pos.entity;

import java.util.List;

import javax.persistence.TypedQuery;

import com.desenvolvimento.pos.util.BaseJPATest;

public class BaseCrudTest<E> extends BaseJPATest{

	/**
	 * Método responsável por salvar entidade.
	 * 
	 * @param entidade
	 */
	public E salvar(E entidade) {
		begin();
		getEm().persist(entidade);
		commit();
		return entidade;
	}
	
	/**
	 * Método responsável por atualizar entidade.
	 * 
	 * @param entidade
	 */
	public E atualizar(E entidade) {
		begin();
		E e = getEm().merge(entidade);
		commit();
		return e;
	}
	
	/**
	 * Responsável por realizar consulta unica com query.
	 * 
	 * @param strQuery
	 * @param clazz
	 * @return
	 */
	public E consultaUnica(String strQuery, Class<E> clazz) {
		TypedQuery<E> query = getEm().createQuery(strQuery, clazz).setMaxResults(1);
		return query.getSingleResult();
	}

	/**
	 * Responsável por realizar consulta unica com query.
	 * 
	 * @param strQuery
	 * @param clazz
	 * @return
	 */
	public void excluir(E entidade) {
		begin();
		getEm().remove(entidade);
		commit();
	}

	/**
	 * Responsável por realizar consulta por id.
	 * 
	 * @param strQuery
	 * @param clazz
	 * @return
	 */
	public E consultaPorId(Long id, Class<E> clazz) {
		return getEm().find(clazz, id);
	}
	
	/**
	 * Responsável por realizar consulta de uma lista de objetos.
	 * 
	 * @param strQuery
	 * @param clazz
	 * @return
	 */
	public List<E> consultaLista(String strQuery, Class<E> clazz) {
		TypedQuery<E> query = getEm().createQuery(strQuery, clazz);
		return query.getResultList();
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
		getEm().getTransaction().commit();
	}
}
