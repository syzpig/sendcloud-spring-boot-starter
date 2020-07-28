package com.jr.ranlo.sendcloud.dto;

import java.io.Serializable;
import java.util.List;

/**
 *@description 邮件实体参数
 *@date 2020/7/28 17:11
 *@author syz
 */
public class CommonEmailMsg implements Serializable {
    /**
     * 收件人
     */
    private List<String> toList;
    /**
     * 添加抄送
     */
    private List<String> ccList;
    /**
     * 添加密送
     */
    private List<String> bccList;
    /**
     * 发件人地址
     */
    private String   from;
    /**
     * 发件人名称
     */
    private String   fromName;
    /**
     * 用户默认的回复邮件地址
     */
    private String   replyTo;
    /**
     * 邮件主题
     */
    private String   subject;
    /**
     * 邮件内容
     */
    private String   text;

    /**
     * 附件地址
     * @return
     */
    private String   fillePath;
    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
    }

    public List<String> getCcList() {
        return ccList;
    }

    public void setCcList(List<String> ccList) {
        this.ccList = ccList;
    }

    public List<String> getBccList() {
        return bccList;
    }

    public void setBccList(List<String> bccList) {
        this.bccList = bccList;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFillePath() {
        return fillePath;
    }

    public void setFillePath(String fillePath) {
        this.fillePath = fillePath;
    }
}
