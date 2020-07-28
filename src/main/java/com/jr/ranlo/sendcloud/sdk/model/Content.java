package com.jr.ranlo.sendcloud.sdk.model;


import com.jr.ranlo.sendcloud.sdk.exception.ContentException;

public interface Content {
	public boolean useTemplate();

	public boolean validate() throws ContentException;
}