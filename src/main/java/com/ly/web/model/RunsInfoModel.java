package com.ly.web.model;

import com.ly.web.db.entity.AppInfoEntity;

import java.util.List;

/**
 * Created by liyang on 15/3/28.
 */
public class RunsInfoModel {

    //需要安装的APP 如果本机没有就更新
    private List<AppInfoEntity> whiteList;

    //黑名单 需要被卸载的APP
    private List<AppInfoEntity> blackList;


    public List<AppInfoEntity> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<AppInfoEntity> whiteList) {
        this.whiteList = whiteList;
    }

    public List<AppInfoEntity> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<AppInfoEntity> blackList) {
        this.blackList = blackList;
    }
}
