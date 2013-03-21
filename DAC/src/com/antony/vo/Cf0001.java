package com.antony.vo;

import java.util.Date;

public class Cf0001 {
    private Integer id;

    private String docid;

    private String fileid;

    private String groupid;

    private String filename;

    private String filepath;

    private String netpath;

    private Date updatetime;

    private Integer userid;

    private String realpath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getNetpath() {
        return netpath;
    }

    public void setNetpath(String netpath) {
        this.netpath = netpath == null ? null : netpath.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRealpath() {
        return realpath;
    }

    public void setRealpath(String realpath) {
        this.realpath = realpath == null ? null : realpath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", docid=").append(docid);
        sb.append(", fileid=").append(fileid);
        sb.append(", groupid=").append(groupid);
        sb.append(", filename=").append(filename);
        sb.append(", filepath=").append(filepath);
        sb.append(", netpath=").append(netpath);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", userid=").append(userid);
        sb.append(", realpath=").append(realpath);
        sb.append("]");
        return sb.toString();
    }
}