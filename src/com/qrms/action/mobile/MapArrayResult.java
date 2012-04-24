package com.qrms.action.mobile;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * Description: this class is designed as a return type of actions, the type is
 * ArrayList<Map<String,Object>>
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class MapArrayResult extends ServletRedirectResult {

	private static final long serialVersionUID = 1L;
	private String contentTypeName;
	private String mapArrayName = "";

	public MapArrayResult() {
		super();
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public void setMapArrayName(String mapArrayName) {
		this.mapArrayName = mapArrayName;
	}

	public String getMapArrayName() {
		return mapArrayName;
	}

	public MapArrayResult(String location) {
		super(location);
	}

	protected void doExecute(String finalLocation, ActionInvocation invocation) {
		HttpServletResponse response = (HttpServletResponse) invocation
				.getInvocationContext().get(HTTP_RESPONSE);

		try {
			OutputStream out = response.getOutputStream();

			ObjectOutputStream oos = new ObjectOutputStream(out);
			ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) invocation
					.getStack().findValue(mapArrayName);
			oos.writeObject(result);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
