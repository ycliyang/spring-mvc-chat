package com.ly.web.db.entity;

import javax.persistence.*;

/**
 * Created by liyang on 15/3/28.
 */
@Entity(name = AppInfoEntity.TAG_NAME)
public class AppInfoEntity {

    public static final String TAG_NAME = "appInfo";

    public static enum Status {
        black(1),
        white(2),
        normal(3);

        int code;
        Status(int code){
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code+"";
        }
    }


    public static final String C_PACKAGE_NAME = "packageName";
    public static final String C_VERSION_CODE = "versionCode";
    public static final String C_APP_NAME = "appName";
    public static final String C_VERSION_NUMBER = "versionNumber";
    public static final String C_STATUS = "status";
    public static final String C_DOWNLOAD = "download";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = C_APP_NAME)
    private String appName;

    @Column(name = C_PACKAGE_NAME)
    private String packageName;

    @Column(name = C_VERSION_CODE)
    private String versionCode;

    @Column(name = C_VERSION_NUMBER)
    private String versionNumber;

    @Column(name = C_STATUS)
    private int status;

    @Column(name = C_DOWNLOAD)
    private int download;


    public AppInfoEntity() {
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
