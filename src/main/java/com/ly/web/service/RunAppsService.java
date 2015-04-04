package com.ly.web.service;

import com.ly.web.db.dao.AppInfoDAO;
import com.ly.web.db.dao.PhoneInfoDAO;
import com.ly.web.db.entity.AppInfoEntity;
import com.ly.web.db.entity.PhoneInfoEntity;
import com.ly.web.model.RunsInfoModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang on 15/3/28.
 * app信息服务
 */
@Service(RunAppsService.TAG_NAME)
public class RunAppsService {

    public static final String TAG_NAME = "runAppsService";

    @Resource
    PhoneInfoDAO phoneInfoDAO = null;

    @Resource
    AppInfoDAO appInfoDAO = null;

    //获取在线的手机
    public List<PhoneInfoEntity> getOnlinePhones(String message) {
        return new ArrayList<PhoneInfoEntity>();
    }

    /**
     * 获取需要处理信息
     *
     * @return
     */
    public RunsInfoModel getRunsInfoModel() {
        RunsInfoModel runsInfoModel = new RunsInfoModel();

        List<AppInfoEntity> blackList = appInfoDAO.findBlackList();
        List<AppInfoEntity> whiteList = appInfoDAO.findWhiteList();

        runsInfoModel.setBlackList(blackList);
        runsInfoModel.setWhiteList(whiteList);
        return runsInfoModel;
    }

    /**
     * 创建一个是APP信息
     *
     * @param appInfoEntity
     */
    public void createAppInfoService(AppInfoEntity appInfoEntity) {

        if (appInfoEntity != null) {
            if (appInfoEntity.getStatus() == AppInfoEntity.Status.white.getCode()) {
                appInfoDAO.findWhiteByPackageAndVersionDao(appInfoEntity);
                if (appInfoEntity.getId() == 0) {
                    appInfoDAO.add(appInfoEntity);
                } else {
                    appInfoDAO.update(appInfoEntity);
                }
            } else {
                AppInfoEntity appInfoEntity1 = appInfoDAO.findBlackByPackageAndVersionDao(appInfoEntity);
                appInfoEntity.setId(appInfoEntity1 != null ? appInfoEntity1.getId() : 0);
                if (appInfoEntity.getId() == 0) {
                    appInfoDAO.add(appInfoEntity);
                } else {
                    appInfoDAO.update(appInfoEntity);
                }

            }
        }

    }

    /**
     * 获取通常名单APP
     * @return
     */
    public List<AppInfoEntity> getAppInfoNormalService() {
        return appInfoDAO.findWhiteList();
    }

    /**
     * 获取黑名单APP
     * @return
     */
    public List<AppInfoEntity> getAppInfoBlackService() {
        return  appInfoDAO.findBlackList();
    }

    /**
     * 查询白名单中的APP信息
     *
     * @return
     */
    public List<AppInfoEntity> getAppInfoWhiteService() {
        return appInfoDAO.findWhiteList();
    }
}
