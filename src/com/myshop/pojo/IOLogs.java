package com.myshop.pojo;

public class IOLogs {
    private Integer id;
    private String ip;
    private String iotime;
    private String behaviour;

    public IOLogs() {
    }

    public IOLogs(Integer id, String ip, String iotime, String behaviour) {
        this.id = id;
        this.ip = ip;
        this.iotime = iotime;
        this.behaviour = behaviour;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIotime() {
        return iotime;
    }

    public void setIotime(String date) {
        this.iotime = date;
    }

    @Override
    public String toString() {
        return "IOLogs{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", iotime='" + iotime + '\'' +
                ", behaviour=" + behaviour +
                '}';
    }
}
