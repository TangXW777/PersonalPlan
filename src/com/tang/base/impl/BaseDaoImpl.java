package com.tang.base.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tang.base.BaseDao;

/**
 * 基础Dao实现类
 * 实现了基本的CRUD操作(包括分页操作)
 * @author TangXW
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
	// 配置注入sessionFactory
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	// 根据id获取实体
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) this.getSessionFactory().getCurrentSession()
				.get(entityClazz, id);
	}
	
	// 保存实体
	public Serializable save(T entity) {
		return this.getSessionFactory().getCurrentSession()
				.save(entity);
	}

	// 更新实体
	public void update(T entity) {
		this.getSessionFactory().getCurrentSession().update(entity);
	}

	// 删除实体
	public void delete(T entity) {
		this.getSessionFactory().getCurrentSession().delete(entity);
	}

	// 根据id删除实体
	public void delete(Class<T> entityClazz, Serializable id) {
		this.getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0")
			.setParameter("0", id)
			.executeUpdate();
	}

	// 查找所有的实体
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	// 获取实体总数
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if(l != null && l.size() == 1){
			return (Long) l.get(0);
		}
		return 0;
	}
	
	// 根据hql查找实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql){
		return this.getSessionFactory().getCurrentSession()
				.createQuery(hql).list();
	}
	
	// 根据有占位符的hql语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params){
		Query query = this.getSessionFactory().getCurrentSession()
				.createQuery(hql);
		for(int i = 0; i < params.length; i++){
			// 因为setParameter()中的index参数只能式String
			query.setParameter(i + "", params[i]); 
		}
		
		return query.list();
	}
	
	/**
	 * 分页操作
	 * @param hql 分页的hql语句
	 * @param pageNo 当前的页数
	 * @param pageSize 每页显示的数目
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize){
		return this.getSessionFactory().getCurrentSession()
				.createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	
	/**
	 * 带占位符的分页操作
	 * @param hql 分页的hql语句
	 * @param pageNo 当前的页数
	 * @param pageSize 每页显示的数目
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo,
				int pageSize, Object... params){
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i + "", params[i]);
		}
		
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}
