package com.vicoga.datajpa.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	private int totalPages;
	private int numberOfItemsPerPage;
	private int actualPage;

	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {
		
		this.url = url;
		this.page = page;
		this.numberOfItemsPerPage=page.getSize();
		this.totalPages=page.getTotalPages();
		this.actualPage=page.getNumber()+1;
		pages= new ArrayList<PageItem>();
		int from, to;
		if (totalPages <= numberOfItemsPerPage) {
			from = 1;
			to = totalPages;
		} else {
			if (actualPage <= numberOfItemsPerPage / 2) {
				from = 1;
				to = numberOfItemsPerPage;
			} else if (actualPage >= totalPages - numberOfItemsPerPage / 2) {
				from = totalPages - numberOfItemsPerPage + 1;
				to = numberOfItemsPerPage;
			} else {
				from = actualPage - numberOfItemsPerPage / 2;
				to = numberOfItemsPerPage;
			}
		}

		for (int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, actualPage == from + i));
		}

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumberOfItemsPerPage() {
		return numberOfItemsPerPage;
	}

	public void setNumberOfItemsPerPage(int numberOfItemsPerPage) {
		this.numberOfItemsPerPage = numberOfItemsPerPage;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public void setPages(List<PageItem> pages) {
		this.pages = pages;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
	

}
