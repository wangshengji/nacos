/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.consistency;

import java.io.Serializable;

/**
 * There is no network traffic involved
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public class LogFuture implements Serializable {

	private static final long serialVersionUID = 5586490452907514669L;

	// If an exception occurs during apply, response==null

	private Object response;

	// If apply succeeds, error==null

	private Throwable error;

	public LogFuture(Object response, Throwable error) {
		this.response = response;
		this.error = error;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

	public Object getResponse() {
		return response;
	}

	public Throwable getError() {
		return error;
	}

	public boolean isOk() {
		return error == null;
	}

	public static LogFuture success(Object data) {
		return new LogFuture(data, null);
	}

	public static LogFuture fail(Throwable error) {
		return new LogFuture(null, error);
	}

	public static LogFuture create(Object data, Throwable error) {
		return new LogFuture(data, error);
	}

	@Override
	public String toString() {
		return "LogFuture{" + "response=" + response + ", error=" + error + '}';
	}
}
