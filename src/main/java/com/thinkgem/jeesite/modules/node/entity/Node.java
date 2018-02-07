/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.node.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 节点Entity
 * @author 王振伟
 * @version 2017-10-26
 */
public class Node extends DataEntity<Node> {
	
	private static final long serialVersionUID = 1L;
	private String ip;		// ip地址
	private String port;		// 端口号
	private String username;		// 用户名
	private String password;		// 密码
	private String nodename1;		// 节点1
	private String nodename2;		// 节点2
	private String path1;		// 文件路径1
	private String path2;		// 文件路径2
	
	public Node() {
		super();
	}

	public Node(String id){
		super(id);
	}

	@Length(min=1, max=100, message="ip地址长度必须介于 1 和 100 之间")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Length(min=1, max=50, message="端口号长度必须介于 1 和 50 之间")
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	@Length(min=1, max=100, message="用户名长度必须介于 1 和 100 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=100, message="节点1长度必须介于 0 和 100 之间")
	public String getNodename1() {
		return nodename1;
	}

	public void setNodename1(String nodename1) {
		this.nodename1 = nodename1;
	}
	
	@Length(min=0, max=100, message="节点2长度必须介于 0 和 100 之间")
	public String getNodename2() {
		return nodename2;
	}

	public void setNodename2(String nodename2) {
		this.nodename2 = nodename2;
	}
	
	@Length(min=0, max=100, message="文件路径1长度必须介于 0 和 100 之间")
	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}
	
	@Length(min=0, max=100, message="文件路径2长度必须介于 0 和 100 之间")
	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}
	
}