package com.myshop.pojo;

public class OPLogs {
    private int id;
    private String ip;
    private String optime;
    private String behaviour;
    private String obj;

    public OPLogs() {
    }

    public OPLogs(int id, String ip, String optime, String behaviour, String obj) {
        this.id = id;
        this.ip = ip;
        this.optime = optime;
        this.behaviour = behaviour;
        this.obj = obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOptime() {
        return optime;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }


    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "OPLogs{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", optime='" + optime + '\'' +
                ", behaviour='" + behaviour + '\'' +
                ", obj='" + obj + '\'' +
                '}';
    }
}
