package com.kms.controller.ViewObject;

public class UserVO {
    private String customerid;
    private String customername;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomershortname() {
        return customershortname;
    }

    public void setCustomershortname(String customershortname) {
        this.customershortname = customershortname;
    }

    private String customershortname;
}
