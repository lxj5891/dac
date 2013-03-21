package org.antonyframework.web.process;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;

public class DefaultProcess extends Process {

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		System.out.println("--------------》");
		return new Result(this.getSuccessView(), model);
	}

}
