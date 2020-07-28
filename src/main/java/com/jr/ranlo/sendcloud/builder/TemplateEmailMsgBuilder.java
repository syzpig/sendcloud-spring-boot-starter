package com.jr.ranlo.sendcloud.builder;

import com.jr.ranlo.sendcloud.dto.TemplateEmailMsg;

import java.util.List;
import java.util.Map;
/**
 *@description ${description}
 *@date 2020/7/28 19:49
 *@author syz
 */
public class TemplateEmailMsgBuilder {
    private TemplateEmailMsg templateEmailMsg = new TemplateEmailMsg();

    public TemplateEmailMsgBuilder addToList(List<String> toList) {
        templateEmailMsg.setToList(toList);
        return this;
    }

    public TemplateEmailMsgBuilder addFrom(String from) {
        templateEmailMsg.setFrom(from);
        return this;
    }

    public TemplateEmailMsgBuilder addFromName(String fromName) {
        templateEmailMsg.setFromName(fromName);
        return this;
    }

    public TemplateEmailMsgBuilder addReplyTo(String replyTo) {
        templateEmailMsg.setReplyTo(replyTo);
        return this;
    }

    public TemplateEmailMsgBuilder addSubject(String subject) {
        templateEmailMsg.setSubject(subject);
        return this;
    }

    public TemplateEmailMsgBuilder addTemplateName(String templateName) {
        templateEmailMsg.setTemplateName(templateName);
        return this;
    }

    public TemplateEmailMsgBuilder addFillePath(String fillePath) {
        templateEmailMsg.setFillePath(fillePath);
        return this;
    }

    public TemplateEmailMsgBuilder addTemplateData(Map<String, List<String>> templateData) {
        templateEmailMsg.setTemplateData(templateData);
        return this;
    }

    public TemplateEmailMsg build() {
        return this.templateEmailMsg;
    }

}
