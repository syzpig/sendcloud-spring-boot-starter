package com.jr.ranlo.sendcloud.sdk.model;


import com.jr.ranlo.sendcloud.autoConfiguration.SendCloudEmailProperties;
import com.jr.ranlo.sendcloud.sdk.config.Config;
import com.jr.ranlo.sendcloud.sdk.exception.ContentException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 文本格式邮件内容
 * 
 * <pre>
 * 需要设置text与content_type
 * </pre>
 * 
 * @author SendCloud
 *
 */
@Service
public class TextContent implements Content {


	/**
	 * 不使用模版发送
	 */
	@Override
	public boolean useTemplate() {
		return false;
	}

	/**
	 * 邮件内容
	 */
	private String text;

	/**
	 * <pre>
	 * 邮件格式：text/html或者text/plain
	 * 
	 * 默认text/html
	 * </pre>
	 */
	public enum ScContentType {
		html, plain
	}

	private ScContentType content_type = ScContentType.html;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ScContentType getContent_type() {
		return content_type;
	}

	/**
	 * 邮件格式：text/html或者text/plain
	 * 
	 * @param content_type
	 */
	public void setContent_type(ScContentType content_type) {
		this.content_type = content_type;
	}

	@Override
	public boolean validate() throws ContentException {
		if (StringUtils.isBlank(text))
			throw new ContentException("邮件内容为空");
		return true;
	}
}