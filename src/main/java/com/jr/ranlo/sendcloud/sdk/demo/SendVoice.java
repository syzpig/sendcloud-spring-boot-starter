package com.jr.ranlo.sendcloud.sdk.demo;


import com.jr.ranlo.sendcloud.sdk.core.SendCloud;
import com.jr.ranlo.sendcloud.sdk.exception.VoiceException;
import com.jr.ranlo.sendcloud.sdk.model.SendCloudVoice;
import com.jr.ranlo.sendcloud.sdk.util.ResponseData;
import org.apache.http.ParseException;

import java.io.IOException;

public class SendVoice {

	public static void send() throws ParseException, IOException, VoiceException {
		SendCloudVoice voice = new SendCloudVoice();
		voice.setCode("123456");
		voice.setPhone("12345678910;12345678911");

		/*SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendVoice(voice);

		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());*/
	}

	public static void main(String[] args) throws Throwable {
		send();
	}
}
