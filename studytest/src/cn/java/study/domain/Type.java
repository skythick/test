package cn.java.study.domain;

import java.util.List;

public class Type {
	private int tid;
	private String typename;
	private int parentid;
	private String remarks;
	private List<Type> children;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public List<Type> getChildren() {
		return children;
	}
	public void setChildren(List<Type> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", typename=" + typename + ", parentid="
				+ parentid + ", remarks=" + remarks + ", children=" + children
				+ "]";
	}
	

}
