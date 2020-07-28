package com.jr.ranlo.sendcloud.autoConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author syz
 * @description ${description}
 * @date 2020/7/27 14:44
 */
@Component
@ConfigurationProperties(prefix = "jr.ranlo.sendcloud.email")
public class SendCloudEmailProperties {

    private String from;
    private String fromName;
    private String replyTo;
    private String apiUser="syz15155966193_test_ZcMQlS";
    private String apiKey="9UrR1F5VwmNsntKQ";
    private String smsUser;
    private String smsKey;
    private Integer maxReceivers=100;
    private Integer maxMailList=5;
    private Integer maxContentSize=1048576;

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

    public void setMaxReceivers(Integer maxReceivers) {
        this.maxReceivers = maxReceivers;
    }

    public void setMaxMailList(Integer maxMailList) {
        this.maxMailList = maxMailList;
    }

    public void setMaxContentSize(Integer maxContentSize) {
        this.maxContentSize = maxContentSize;
    }

    public String getApiUser() {
        return apiUser;
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSmsUser() {
        return smsUser;
    }

    public void setSmsUser(String smsUser) {
        this.smsUser = smsUser;
    }

    public String getSmsKey() {
        return smsKey;
    }

    public void setSmsKey(String smsKey) {
        this.smsKey = smsKey;
    }

    public int getMaxReceivers() {
        return maxReceivers;
    }

    public void setMaxReceivers(int maxReceivers) {
        this.maxReceivers = maxReceivers;
    }

    public int getMaxMailList() {
        return maxMailList;
    }

    public void setMaxMailList(int maxMailList) {
        this.maxMailList = maxMailList;
    }

    public int getMaxContentSize() {
        return maxContentSize;
    }

    public void setMaxContentSize(int maxContentSize) {
        this.maxContentSize = maxContentSize;
    }
}
