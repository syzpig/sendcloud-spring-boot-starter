package com.jr.ranlo.sendcloud.sdk.model;

import com.jr.ranlo.sendcloud.autoConfiguration.SendCloudEmailProperties;
import com.jr.ranlo.sendcloud.sdk.config.Config;
import com.jr.ranlo.sendcloud.sdk.exception.ReceiverException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邮件地址收件人
 * 
 * @author SendCloud
 *
 */

public class MailAddressReceiver implements Receiver {



	/**
	 * 广播发送(收件人会全部显示)
	 */
	public boolean broadcastSend = true;

	/**
	 * 收件人
	 */
	private List<String> to;
	/**
	 * 抄送
	 */
	private List<String> cc;
	/**
	 * 密送
	 */
	private List<String> bcc;

	public List<String> getTo() {
		return to;
	}

	public List<String> getCc() {
		return cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void addTo(List<String> address) {
		if (to == null)
			to = new ArrayList<String>();
		to.addAll(address);
	}

	public void addCc(List<String> address) {
		if (cc == null)
			cc = new ArrayList<String>();

		cc.addAll(address);
	}

	public void addBcc(List<String> address) {
		if (bcc == null)
			bcc = new ArrayList<String>();
		bcc.addAll(address);
	}

	public boolean isBroadcastSend() {
		return broadcastSend;
	}

	public void setBroadcastSend(boolean broadcastSend) {
		this.broadcastSend = broadcastSend;
	}

	@Override
	public boolean useAddressList() {
		return false;
	}
	@Override
	public boolean validate() throws ReceiverException {
		if (CollectionUtils.isEmpty(to))
			throw new ReceiverException("收件人为空");
		int receivers = to.size();
		if (CollectionUtils.isNotEmpty(cc))
			receivers += cc.size();
		if (CollectionUtils.isNotEmpty(bcc))
			receivers += bcc.size();
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String address : to) {
			if (sb.length() > 0)
				sb.append(";");
			sb.append(address);
		}
		return sb.toString();
	}

	public String getCcString() {
		if (CollectionUtils.isEmpty(cc))
			return null;
		StringBuilder sb = new StringBuilder();
		for (String address : cc) {
			if (sb.length() > 0)
				sb.append(";");
			sb.append(address);
		}
		return sb.toString();
	}

	public String getBccString() {
		if (CollectionUtils.isEmpty(bcc))
			return null;
		StringBuilder sb = new StringBuilder();
		for (String address : bcc) {
			if (sb.length() > 0)
				sb.append(";");
			sb.append(address);
		}
		return sb.toString();
	}
}