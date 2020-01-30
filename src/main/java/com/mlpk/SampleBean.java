package com.mlpk;

import java.util.Date;

public class SampleBean {

    private String param1;
    private Date param2 = new Date();

    public String getParam1() {
        return param1;
    }
    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public Date getParam2() {
        return param2;
    }
    public void setParam2(Date param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "SampleBean [param1=" + param1 + ", param2=" + param2 + "]";
    }

}
