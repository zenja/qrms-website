package com.qrms.action.mobile;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * Description: this class is designed as a return type of actions, the type is
 * String
 * 
 * @author ZhaoLu & WangXin
 * @version 1.0
 */
public class StringResult extends ServletRedirectResult {

	private static final long serialVersionUID = 1L;
	private String contentTypeName;
	private String stringName = "";

	public StringResult() {
		super();
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public String getStringName() {
		return stringName;
	}

	public void setStringName(String stringName) {
		this.stringName = stringName;
	}

	public StringResult(String location) {
		super(location);
	}

	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		HttpServletResponse response = (HttpServletResponse) invocation
				.getInvocationContext().get(HTTP_RESPONSE);

		String contentType = conditionalParse(contentTypeName, invocation);
		if (contentType == null) {
			contentType = "text/plain; charset=UTF-8";
		}
		response.setContentType(contentType);
		PrintWriter out = response.getWriter();

		String result = (String) invocation.getStack().findValue(stringName);
		out.println(result);
		out.flush();
		out.close();
	}

}