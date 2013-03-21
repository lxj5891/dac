package com.antony.service.mail.vo;

import java.util.Date;

public class Cm3001 {
    private Integer id;

    private String senderaddr;

    private String sendername;

    private String receiveraddr;

    private Integer hit;

    private String ccs;

    private String bccs;

    private String subject;

    private Date senddate;

    private String resendno;

    private String status;

    private Integer actno;

    private String scheduletype;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderaddr() {
        return senderaddr;
    }

    public void setSenderaddr(String senderaddr) {
        this.senderaddr = senderaddr == null ? null : senderaddr.trim();
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }

    public String getReceiveraddr() {
        return receiveraddr;
    }

    public void setReceiveraddr(String receiveraddr) {
        this.receiveraddr = receiveraddr == null ? null : receiveraddr.trim();
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String getCcs() {
        return ccs;
    }

    public void setCcs(String ccs) {
        this.ccs = ccs == null ? null : ccs.trim();
    }

    public String getBccs() {
        return bccs;
    }

    public void setBccs(String bccs) {
        this.bccs = bccs == null ? null : bccs.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getResendno() {
        return resendno;
    }

    public void setResendno(String resendno) {
        this.resendno = resendno == null ? null : resendno.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getActno() {
        return actno;
    }

    public void setActno(Integer actno) {
        this.actno = actno;
    }

    public String getScheduletype() {
        return scheduletype;
    }

    public void setScheduletype(String scheduletype) {
        this.scheduletype = scheduletype == null ? null : scheduletype.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}