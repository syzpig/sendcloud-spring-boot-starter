package com.jr.ranlo.sendcloud.autoConfiguration;

import com.jr.ranlo.sendcloud.sdk.core.SendCloud;
import com.jr.ranlo.sendcloud.sdk.model.AddressListReceiver;
import com.jr.ranlo.sendcloud.sdk.model.MailAddressReceiver;
import com.jr.ranlo.sendcloud.sdk.model.TextContent;
import com.jr.ranlo.sendcloud.service.SendCloudEmailService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author syz
 * @description ${description}
 * @date 2020/7/27 14:42
 */
@EnableConfigurationProperties(SendCloudEmailProperties.class)
@Configuration
public class SendCloudEmailAutoConfiguration {
    @Bean
    public SendCloudEmailService getSendCloudEmailService() {
        return new SendCloudEmailService();
    }

    @Bean
    public SendCloud getSendCloud() {
        return new SendCloud();
    }
}
