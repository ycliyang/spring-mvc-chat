package com.ly.web.db.dao;

import com.ly.web.db.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.marshalling.TraceInformation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.naming.directory.Attributes;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDAO extends BasicDAO<UserEntity> {



    public List<UserEntity> getAllUser() {

        List<UserEntity> list = new ArrayList<UserEntity>();
        return list;
    }
}
