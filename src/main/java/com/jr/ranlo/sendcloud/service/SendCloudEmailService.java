package com.jr.ranlo.sendcloud.service;


import com.jr.ranlo.sendcloud.builder.CommonEmailMsgBuilder;
import com.jr.ranlo.sendcloud.builder.TemplateEmailMsgBuilder;
import com.jr.ranlo.sendcloud.dto.CommonEmailMsg;
import com.jr.ranlo.sendcloud.dto.TemplateEmailMsg;
import com.jr.ranlo.sendcloud.sdk.core.SendCloud;
import com.jr.ranlo.sendcloud.sdk.model.*;
import com.jr.ranlo.sendcloud.sdk.util.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;


/**
 * @author syz
 * @description sendCloud邮件推送
 * @date 2020/7/27 14:31
 */

public class SendCloudEmailService {
    private static final Logger log = LoggerFactory.getLogger(SendCloudEmailService.class);
    @Autowired
    private SendCloud sendCloud;

    /**
     * @param
     * @return
     * @description 文本格式邮件推送
     */
    public void sendText(CommonEmailMsgBuilder commonEmailMsgBuilder) throws Throwable {
        CommonEmailMsg commonEmailMsg = commonEmailMsgBuilder.build();
        MailAddressReceiver receiver = new MailAddressReceiver();
        // 添加收件人
        receiver.addTo(commonEmailMsg.getToList());
        // 添加抄送
        receiver.addCc(commonEmailMsg.getCcList());
        // 添加密送
        receiver.addBcc(commonEmailMsg.getBccList());

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(commonEmailMsg.getFrom());
        // 设置 FromName
        body.setFromName(commonEmailMsg.getFromName());
        // 设置 ReplyTo
        body.setReplyTo(commonEmailMsg.getReplyTo());
        // 设置标题
        body.setSubject(commonEmailMsg.getSubject());
        TextContent content = new TextContent();
        content.setContent_type(TextContent.ScContentType.html);
        content.setText(commonEmailMsg.getText());


        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);
        ResponseData res = sendCloud.sendMail(mail);
        if (!res.getResult()) {
            log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + res.getStatusCode() + ";errorMsg=" + res.getMessage());
            ResponseData retryRes = sendCloud.sendMail(mail);
            if (!retryRes.getResult()) {
                log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + retryRes.getStatusCode() + ";errorMsg=" + retryRes.getMessage() + ";errorInfo=" + retryRes.getInfo());
            }
            log.info("发送邮件通知成功！");
        }

    }

    /**
     * @param
     * @return
     * @description html格式邮件推送
     */
    public void sendHtml(CommonEmailMsgBuilder commonEmailMsgBuilder) throws Throwable {
        CommonEmailMsg commonEmailMsg = commonEmailMsgBuilder.build();
        MailAddressReceiver receiver = new MailAddressReceiver();
        // 添加收件人
        receiver.addTo(commonEmailMsg.getToList());
        // 添加抄送
        receiver.addCc(commonEmailMsg.getCcList());
        // 添加密送
        receiver.addBcc(commonEmailMsg.getBccList());

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(commonEmailMsg.getFrom());
        // 设置 FromName
        body.setFromName(commonEmailMsg.getFromName());
        // 设置 ReplyTo
        body.setReplyTo(commonEmailMsg.getReplyTo());
        // 设置标题
        body.setSubject(commonEmailMsg.getSubject());
        // 创建文件附件
        if (StringUtils.isNotEmpty(commonEmailMsg.getFillePath())) {
            body.addAttachments(new File(commonEmailMsg.getFillePath()));
        }

        TextContent content = new TextContent();
        content.setContent_type(TextContent.ScContentType.plain);
        content.setText(commonEmailMsg.getText());

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);

        // SendCloud sc = SendCloudBuilder.build();
        ResponseData res = sendCloud.sendMail(mail);
        if (!res.getResult()) {
            log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + res.getStatusCode() + ";errorMsg=" + res.getMessage());
            ResponseData retryRes = sendCloud.sendMail(mail);
            if (!retryRes.getResult()) {
                log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + retryRes.getStatusCode() + ";errorMsg=" + retryRes.getMessage() + ";errorInfo=" + retryRes.getInfo());
            }
            log.info("发送邮件通知成功！");
        }
    }

    /**
     * @param
     * @return
     * @description 自定义模板数据类型的邮件推送
     */
    public void sendAutoTemplate(TemplateEmailMsgBuilder templateEmailMsgBuilder) throws Throwable {
        TemplateEmailMsg templateEmailMsg  = templateEmailMsgBuilder.build();
        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(templateEmailMsg.getFrom());
        // 设置 FromName
        body.setFromName(templateEmailMsg.getFromName());
        // 设置 ReplyTo
        body.setReplyTo(templateEmailMsg.getReplyTo());
        // 设置标题
        body.setSubject(templateEmailMsg.getSubject());
        // 创建文件附件
        if (StringUtils.isNotEmpty(templateEmailMsg.getFillePath())) {
            body.addAttachments(new File(templateEmailMsg.getFillePath()));
        }

        // 此时, receiver 中添加的 to, cc, bcc 均会失效
        body.addXsmtpapi("to", templateEmailMsg.getToList());
        body.addXsmtpapi("sub", templateEmailMsg.getTemplateData());
        body.addHeader("SC-Custom-test_key1", "test1");
        body.addHeader("NO-SC-Custom-test_key1", "test2");

        // 使用邮件模板
        TemplateContent content = new TemplateContent();
        content.setTemplateInvokeName(templateEmailMsg.getTemplateName());

        SendCloudMail mail = new SendCloudMail();
        // 模板发送时, 必须使用 Xsmtpapi 来指明收件人; demo.setTo();
        mail.setBody(body);
        mail.setContent(content);

        // SendCloud sc = SendCloudBuilder.build();
        ResponseData res = sendCloud.sendMail(mail);
        if (!res.getResult()) {
            log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + res.getStatusCode() + ";errorMsg=" + res.getMessage());
            ResponseData retryRes = sendCloud.sendMail(mail);
            if (!retryRes.getResult()) {
                log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + retryRes.getStatusCode() + ";errorMsg=" + retryRes.getMessage() + ";errorInfo=" + retryRes.getInfo());
            }
            log.info("发送邮件通知成功！");
        }
    }

    /**
     * @param
     * @return
     * @description 使用地址列表进行邮件推送
     */
    public void sendTemplateByAddressList(TemplateEmailMsgBuilder templateEmailMsgBuilder) throws Throwable {
        TemplateEmailMsg templateEmailMsg  = templateEmailMsgBuilder.build();
        AddressListReceiver receiver = new AddressListReceiver();
        // 设置地址列表
        receiver.addTo(templateEmailMsg.getToList());

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(templateEmailMsg.getFrom());
        // 设置 FromName
        body.setFromName(templateEmailMsg.getFromName());
        // 设置 ReplyTo
        body.setReplyTo(templateEmailMsg.getReplyTo());
        // 设置标题
        body.setSubject(templateEmailMsg.getSubject());
        // 创建文件附件
        if (StringUtils.isNotEmpty(templateEmailMsg.getFillePath())) {
            body.addAttachments(new File(templateEmailMsg.getFillePath()));
        }
        // 使用邮件模板
        TemplateContent content = new TemplateContent();
        content.setTemplateInvokeName(templateEmailMsg.getTemplateName());
        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(content);
        ResponseData res = sendCloud.sendMail(mail);
        if (!res.getResult()) {
            log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + res.getStatusCode() + ";errorMsg=" + res.getMessage());
            ResponseData retryRes = sendCloud.sendMail(mail);
            if (!retryRes.getResult()) {
                log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + retryRes.getStatusCode() + ";errorMsg=" + retryRes.getMessage() + ";errorInfo=" + retryRes.getInfo());
            }
            log.info("发送邮件通知成功！");
        }
    }

    /**
     * @param
     * @return
     * @description 普通模板类型的邮件推送
     */
    public void sendTemplate(TemplateEmailMsgBuilder templateEmailMsgBuilder) throws Throwable {
        TemplateEmailMsg templateEmailMsg  = templateEmailMsgBuilder.build();
        MailBody body = new MailBody();
        // 设置 From
        body.setFrom(templateEmailMsg.getFrom());
        // 设置 FromName
        body.setFromName(templateEmailMsg.getFromName());
        // 设置 ReplyTo
        body.setReplyTo(templateEmailMsg.getReplyTo());
        // 设置标题
        body.setSubject(templateEmailMsg.getSubject());
        // 创建文件附件
        if (StringUtils.isNotEmpty(templateEmailMsg.getFillePath())) {
            body.addAttachments(new File(templateEmailMsg.getFillePath()));
        }
        body.addXsmtpapi("to", templateEmailMsg.getToList());
        body.addHeader("SC-Custom-test_key1", "test1");
        body.addHeader("NO-SC-Custom-test_key1", "test2");

        // 使用邮件模板
        TemplateContent content = new TemplateContent();
        content.setTemplateInvokeName(templateEmailMsg.getTemplateName());

        SendCloudMail mail = new SendCloudMail();
        // 模板发送时, 必须使用 Xsmtpapi 来指明收件人; demo.setTo();
        mail.setBody(body);
        mail.setContent(content);
        ResponseData res = sendCloud.sendMail(mail);
        if (!res.getResult()) {
            log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + res.getStatusCode() + ";errorMsg=" + res.getMessage());
            ResponseData retryRes = sendCloud.sendMail(mail);
            if (!retryRes.getResult()) {
                log.info("第一次发送邮件通知失败 发起重试！ errorCode=" + retryRes.getStatusCode() + ";errorMsg=" + retryRes.getMessage() + ";errorInfo=" + retryRes.getInfo());
            }
            log.info("发送邮件通知成功！");
        }
    }

}
