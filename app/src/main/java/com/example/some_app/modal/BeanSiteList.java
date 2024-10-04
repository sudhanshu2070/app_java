package com.example.some_app.modal;

import java.util.List;

public class BeanSiteList extends BeansErrorResponse {
	List<BeansSiteView> site_list;

	public List<BeansSiteView> getSite_list() {
		return site_list;
	}
	public void setSite_list(List<BeansSiteView> site_list) {
		this.site_list = site_list;
	}
}
