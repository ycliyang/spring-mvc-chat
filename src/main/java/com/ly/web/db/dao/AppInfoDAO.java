package com.ly.web.db.dao;

import com.ly.web.db.entity.AppInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liyang on 15/3/28.
 */
@Repository
public class AppInfoDAO extends BasicDAO<AppInfoEntity> {

    public List<AppInfoEntity> findBlackList(){
        return query("from "+AppInfoEntity.TAG_NAME+" where status=?", AppInfoEntity.Status.black.toString());
    }

    public List<AppInfoEntity> findWhiteList() {
        return query("from "+AppInfoEntity.TAG_NAME+" where status=?", AppInfoEntity.Status.white.toString());
    }

    /**
     * 查询白名单中的APP
     * @param appInfoEntity
     * @return
     */
    public AppInfoEntity findWhiteByPackageAndVersionDao(AppInfoEntity appInfoEntity) {

        String hql = "from "+AppInfoEntity.TAG_NAME+" where "+AppInfoEntity.C_PACKAGE_NAME+"=? and "+AppInfoEntity.C_VERSION_CODE+" and "+AppInfoEntity.C_STATUS+"=?";

        return queryOne(hql,
                appInfoEntity.getPackageName(),appInfoEntity.getVersionCode(),appInfoEntity.getStatus());
    }


    /**
     * 查询黑名单中的APP
     * @param appInfoEntity
     * @return
     */
    public AppInfoEntity findBlackByPackageAndVersionDao(AppInfoEntity appInfoEntity) {

        String hql = "from "+AppInfoEntity.TAG_NAME+" where "+AppInfoEntity.C_PACKAGE_NAME+"=? and "+AppInfoEntity.C_STATUS+"=?";

        return queryOne(hql,
                appInfoEntity.getPackageName(),appInfoEntity.getStatus());
    }
}
