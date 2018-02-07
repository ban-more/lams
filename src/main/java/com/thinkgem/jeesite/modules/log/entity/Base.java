package com.thinkgem.jeesite.modules.log.entity;

import java.util.Date;

/**
 * Created by wzw on 2018/1/15.
 */
public class Base {
    private String dat;
    private String policys;
    private String insurance;

    public String getPolicys() {
        return policys;
    }

    public void setPolicys(String policys) {
        this.policys = policys;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }
}
