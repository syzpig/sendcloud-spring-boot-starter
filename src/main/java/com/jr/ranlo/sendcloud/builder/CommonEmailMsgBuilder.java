package com.jr.ranlo.sendcloud.builder;

import com.jr.ranlo.sendcloud.dto.CommonEmailMsg;
import com.jr.ranlo.sendcloud.dto.TemplateEmailMsg;

import java.util.List;

/**
 *@description ${description}
 *@date 2020/7/28 19:52
 *@author syz
 */
public class CommonEmailMsgBuilder {

    private CommonEmailMsg commonEmailMsg = new CommonEmailMsg();


    public CommonEmailMsgBuilder addToList(List<String> toList) {
        commonEmailMsg.setToList(toList);
        return this;
    }

    public CommonEmailMsgBuilder addCcList(List<String> ccList) {
        commonEmailMsg.setCcList(ccList);

        return this;
    }

    public CommonEmailMsgBuilder addBccList(List<String> bccList) {
        commonEmailMsg.setBccList(bccList);
        return this;
    }

    public CommonEmailMsgBuilder addFrom(String from) {
        commonEmailMsg.setFrom(from);
        return this;
    }

    public CommonEmailMsgBuilder addFromName(String fromName) {
        commonEmailMsg.setFromName(fromName);
        return this;
    }

    public CommonEmailMsgBuilder addReplyTo(String replyTo) {
        commonEmailMsg.setReplyTo(replyTo);
        return this;
    }

    public CommonEmailMsgBuilder addSubject(String subject) {
        commonEmailMsg.setSubject(subject);
        return this;
    }

    public CommonEmailMsgBuilder addText(String text) {
        commonEmailMsg.setText(text);
        return this;
    }

    public CommonEmailMsgBuilder addFillePath(String fillePath) {
        commonEmailMsg.setFillePath(fillePath);
        return this;
    }

    public CommonEmailMsg build() {
        return this.commonEmailMsg;
    }
}
