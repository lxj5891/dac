package com.antony.vo;

import java.util.Date;

public class Sm3001 {
    private Integer id;

    private String seq;

    private String name;

    private String uid;

    private String pass;

    private String school;

    private String nick;

    private String skey;

    private String email;

    private Integer fileid;

    private String filepath;

    private Integer userid;

    private Date updatetime;

    private Date sendtime;

    private Integer emailid;

    private String typeid;

    private Date plandate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq == null ? null : seq.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getEmailid() {
        return emailid;
    }

    public void setEmailid(Integer emailid) {
        this.emailid = emailid;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    public Date getPlandate() {
        return plandate;
    }

    public void setPlandate(Date plandate) {
        this.plandate = plandate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", seq=").append(seq);
        sb.append(", name=").append(name);
        sb.append(", uid=").append(uid);
        sb.append(", pass=").append(pass);
        sb.append(", school=").append(school);
        sb.append(", nick=").append(nick);
        sb.append(", skey=").append(skey);
        sb.append(", email=").append(email);
        sb.append(", fileid=").append(fileid);
        sb.append(", filepath=").append(filepath);
        sb.append(", userid=").append(userid);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", sendtime=").append(sendtime);
        sb.append(", emailid=").append(emailid);
        sb.append(", typeid=").append(typeid);
        sb.append(", plandate=").append(plandate);
        sb.append("]");
        return sb.toString();
    }
}