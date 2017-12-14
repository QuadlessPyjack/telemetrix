/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author bogdanv
 */
public class HomeService {

    private final String _defaultPage = "/contentViews/default.xhtml";
    private String _currentPage;
    private final String _rootUrl = "/contentViews/";
    private final String _pageSuffix = ".xhtml";

    public HomeService() {
        this._currentPage = _defaultPage;
    }

    public void setCurrentPage(String pageName) {
        if (pageName == null) {
            return;
        }

        if (pageName.isEmpty()) {
            return;
        }

        this._currentPage = urlBuilder(pageName);
    }

    public String getCurrentPage() {
        return this._currentPage;
    }

    public String getDefaultPage() {
        return this._defaultPage;
    }

    private String urlBuilder(String pageName) {
        String pageUrl = this._rootUrl + pageName + this._pageSuffix;
        return pageUrl;
    }

}
