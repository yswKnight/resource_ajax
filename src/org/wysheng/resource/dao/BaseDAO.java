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
	 * ͨ�������ȡ����ȷ���ķ�����
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
	 * ����ID����POʵ��
	 * 
	 * @param id
	 * @return ������Ӧ�ĳ־û�POʵ��
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * ����ID��ȡPOʵ��
	 * 
	 * @param id
	 * @return ������Ӧ�ĳ־û�POʵ��
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * ��ȡPO�����ж���
	 * 
	 * @return
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * ����PO
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
	 * ɾ��PO
	 * 
	 * @param entity
	 */
	public void remove(Serializable id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ����PO
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * ִ��HQL��ѯ
	 * 
	 * @param sql
	 * @return ��ѯ���
	 */
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ִ�д��ε�HQL��ѯ
	 * 
	 * @param sql
	 * @param params
	 * @return ��ѯ���
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	/**
	 * ���ӳټ��ص�ʵ��POִ�г�ʼ��
	 * 
	 * @param entity
	 */
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	
	// ��ҳ
	/*******************************************
	 * @param hql  ��ѯ��ҳ��hql���
	 * @param pageNo ��ǰҳ
	 * @param pageSize ÿһҳ��ʾ��¼���� 
	 * @param params hql�����Ҫ���õĲ���
	 *  page ��ò�ѯ����(������ҳ������Ϣ��
	 */
	@SuppressWarnings("unchecked")
	public  Page<T>  executePage(final String hql,final int pageNo,final int pageSize,final Object... params){
		
		Page<T> page = new Page<T>();
		// ����ÿһҳ��ʾ��¼����
		page.setPageSize(pageSize);
		// ���õ�ǰҳ
		page.setPageNo(pageNo);
		// ��ѯ��������ܼ�¼��������ҳ��
		String  countSql = getSelectCountSql(hql);
		List list = find(countSql, params);
		long itemTotal = 0;
		if(list.size() > 0){
			itemTotal =(Long) list.get(0);
		}
		page.setItemTotal(itemTotal); // ������ҳ��(������Ҫ����ÿһҳ��ʾ��¼�������ܼ�¼��)
		// ��ѯ��Ӧ�����ݼ���
		
		List<T> result = this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				// ���ò���
				for(int i = 0;i < params.length;i++){
					query.setParameter(i, params[i]);
				}
				List<T> list = query.setFirstResult( (pageNo-1)*pageSize).setMaxResults(pageSize).list();
				
				return list;
			}
			
		});
		
		// �ѻ��List���ϱ��浽page������
		page.setResult(result);
		
		return page;
	}
	
	
	/*****************************************
	 * 
	 * @param hql ��Ҫ��ҳ��hql���
	 * @return  ��Ӧ��ѯ�ܼ�¼������hql���
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
