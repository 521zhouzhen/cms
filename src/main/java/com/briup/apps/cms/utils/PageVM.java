
package com.briup.apps.cms.utils;



//分页处理




import java.util.List;

public class PageVM<E> {
	private Integer page;
	private Integer pageSize;
	private Long total;
	private List<E> list;

	public PageVM() {

	}

	public PageVM(Integer page, Integer pageSize, Long total, List<E> list) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
		this.list = list;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
}

