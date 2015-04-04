package com.ly.web.db.entity;

import javax.persistence.*;

/**
 * Created by liyang on 15/3/28.
 */
@Entity(name = PhoneInfoEntity.TAG_NAME)
public class PhoneInfoEntity {


    public static final String TAG_NAME = "phones";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="phoneName",length=100)
    private String phoneName;

    @Column(name="imei",length=100)
    private String imei;

    //安装量
    @Column(name="install")
    private int install;

    //点击量
    @Column(name="click")
    private int click;

    //修改事件
    @Column(name = "updateTime")
    private long updateTime;

    //创建事件
    @Column(name = "createTime")
    private long createTime;



    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getInstall() {
        return install;
    }

    public void setInstall(int install) {
        this.install = install;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }
}
