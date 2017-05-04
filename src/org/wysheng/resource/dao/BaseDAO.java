package org.wysheng.resource.dao;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class BaseDAO<T> {

	private Class<T> entityClass;

	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDAO() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	

	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 获取PO的所有对象
	 * 
	 * @return
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	
	public void saveorupdate(T entity){
		
		getHibernateTemplate().saveOrUpdate(entity);
	}
	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	public void remove(Serializable id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 执行带参的HQL查询
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	/**
	 * 对延迟加载的实体PO执行初始化
	 * 
	 * @param entity
	 */
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	
	// 分页
	/*******************************************
	 * @param hql  查询分页的hql语句
	 * @param pageNo 当前页
	 * @param pageSize 每一页显示记录条数 
	 * @param params hql语句需要设置的参数
	 *  page 获得查询对象(包括分页基本信息）
	 */
	@SuppressWarnings("unchecked")
	public  Page<T>  executePage(final String hql,final int pageNo,final int pageSize,final Object... params){
		
		Page<T> page = new Page<T>();
		// 设置每一页显示记录条数
		page.setPageSize(pageSize);
		// 设置当前页
		page.setPageNo(pageNo);
		// 查询并计算出总记录条数与总页数
		String  countSql = getSelectCountSql(hql);
		List list = find(countSql, params);
		long itemTotal = 0;
		if(list.size() > 0){
			itemTotal =(Long) list.get(0);
		}
		page.setItemTotal(itemTotal); // 计算总页数(必须先要设置每一页显示记录条数和总记录数)
		// 查询对应的数据集合
		
		List<T> result = this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				// 设置参数
				for(int i = 0;i < params.length;i++){
					query.setParameter(i, params[i]);
				}
				List<T> list = query.setFirstResult( (pageNo-1)*pageSize).setMaxResults(pageSize).list();
				
				return list;
			}
			
		});
		
		// 把获得List集合保存到page对象中
		page.setResult(result);
		
		return page;
	}
	
	
	/*****************************************
	 * 
	 * @param hql 需要分页的hql语句
	 * @return  对应查询总记录条数的hql语句
	 */
	private static String getSelectCountSql(String hql){
		
		StringBuilder hqlCountSql = new StringBuilder();
		if(hql != null){
			
			hqlCountSql.append("select count(*) ");
			hqlCountSql.append(hql.substring(hql.toLowerCase().indexOf("from")));
			//hqlCountSql += "select count(*) " + hql.substring(hql.toLowerCase().indexOf("from"));
		}
		
		return hqlCountSql.toString();
		
	}
	
	
	
	
	
}
