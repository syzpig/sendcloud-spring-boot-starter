package com.jr.ranlo.sendcloud.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *@description 邮件实体参数
 *@date 2020/7/28 17:11
 *@author syz
 */
public class TemplateEmailMsg implements Serializable {
    /**
     * 收件人
     */
    private List<String> toList;
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
     * 模板名
     */
    private String   templateName;

    /**
     * 附件地址
     * @return
     */
    private String   fillePath;

    /**
     *  模板数据
     * @return
     */
   private Map<String, List<String>> templateData;

    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFillePath() {
        return fillePath;
    }

    public void setFillePath(String fillePath) {
        this.fillePath = fillePath;
    }

    public Map<String, List<String>> getTemplateData() {
        return templateData;
    }

    public void setTemplateData(Map<String, List<String>> templateData) {
        this.templateData = templateData;
    }
}
