package com.jr.ranlo.sendcloud.sdk.model;


import com.jr.ranlo.sendcloud.sdk.exception.ReceiverException;

public interface Receiver {
	public boolean useAddressList();
	
	public boolean validate() throws ReceiverException;
	
	public String toString();
}