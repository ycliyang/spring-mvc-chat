package com.ly.web.db.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang on 15/3/28.
 * 基础Dao工具
 */
public class BasicDAO<T extends Object> {


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }


    /**
     * @param obj 添加数据
     * @return
     */
    public boolean add(T obj) {
        Session session = null;
        Transaction tran = null;
        boolean result = false;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.save(obj);
            tran.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tran != null) {
                //事物回滚
                tran.rollback();
            }
        } finally {
            if (session != null) {
                //关闭session
                session.close();
            }
        }
        return result;
    }

    /**
     * @return 更新数据
     * 参数为修改的主键id对象
     */
    public boolean update(T object) {
        Session session = null;
        Transaction tran = null;
        boolean result = false;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.update(object);
            tran.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tran != null) {
                //事物回滚
                tran.rollback();
            }
        } finally {
            if (session != null) {
                //关闭session
                session.close();
            }
        }
        return result;
    }

    /**
     * @param c
     * @param obj 查询一条数据根据主键的id号
     * @return
     */
    public Object get(T c, int obj) {
        Session session = null;
        Object object = null;
        try {
            session = getSession();
            object = session.get(c.getClass(), obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                //关闭session
                session.close();
            }
        }
        return object;
    }

    /**
     * @param obj
     * @return 删除数据
     */
    public boolean delete(T obj) {
        Session session = null;
        Transaction tran = null;
        boolean result = false;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.delete(obj);
            tran.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (tran != null) {
                //事物回滚
                tran.rollback();
            }
        } finally {
            if (session != null) {
                //关闭session
                session.close();
            }
        }
        return result;
    }


    /**
     *   查询多条记录
     * @param sql   sql语句
     * @param param 参数数组
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> query(String sql, String[] param) {
        List<T> list = new ArrayList<T>();
        Session session = null;
        try {
            session = getSession();
            Query query = session.createQuery(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    query.setString(i, param[i]);
                }
            }
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public List<T> query(String sql, String param) {
        List<T> list = new ArrayList<T>();
        Session session = null;
        try {
            session = getSession();
            Query query = session.createQuery(sql);
            query.setString(0, param);
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    /**
     * @param sql
     * @param param 查询单条记录
     * @return
     */
    public T queryOne(String sql, Object... param) {
        T object = null;
        Session session = null;
        try {
            session = getSession();
            Query query = session.createQuery(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    query.setString(i, param[i].toString());
                }
                object =(T) query.uniqueResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return object;
    }
    /**
     * 单条查询
     * @param sql
     * @param param
     * @return
     */
    public Object queryOne(String sql, String param) {
        Object object = null;
        Session session = null;
        try {
            session = getSession();
            Query query = session.createQuery(sql);
            if (param != null) {
                query.setString(0, param);
                object = query.uniqueResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return object;
    }

    /**
     * @param <T>
     * @param sql
     * @param param
     * @param page
     * @param size
     * @return 实现分页查询
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> queryByPage(String sql, String[] param, int page, int size) {
        List<T> list = new ArrayList<T>();
        Session session = null;
        try {
            session = getSession();
            Query query = session.createQuery(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    query.setString(i, param[i]);
                }
            }
            //筛选条数
            query.setFirstResult((page - 1) * size);
            query.setMaxResults(size);
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    /**
     * @param hql
     * @param pras
     * @return返回数据个数
     */
    public int getCount(String hql, String[] pras) {
        int resu = 0;
        Session s = null;
        try {
            s = getSession();
            Query q = s.createQuery(hql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    q.setString(i, pras[i]);
                }
            }
            resu = Integer.valueOf(q.iterate().next().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (s != null)
                s.close();
        }
        return resu;
    }

}
