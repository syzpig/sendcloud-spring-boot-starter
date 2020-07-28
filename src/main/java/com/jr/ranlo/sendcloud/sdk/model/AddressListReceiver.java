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
 * 邮件列表收件人
 * 
 * @author SendCloud
 *
 */

public class AddressListReceiver implements Receiver {


	@Override
	public boolean useAddressList() {
		return true;
	}

	/**
	 * 地址列表
	 */
	private List<String> invokeNames = new ArrayList<String>();

	public List<String> getInvokeNames() {
		return invokeNames;
	}

	/**
	 * 增加地址列表的调用名称
	 * 
	 * @param to
	 */
	public void addTo(List<String> to) {
		invokeNames.addAll(to);
	}
	@Override
	public boolean validate() throws ReceiverException {
		if (CollectionUtils.isEmpty(invokeNames))
			throw new ReceiverException("地址列表为空");
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String address : invokeNames) {
			if (sb.length() > 0)
				sb.append(";");
			sb.append(address);
		}
		return sb.toString();
	}
}