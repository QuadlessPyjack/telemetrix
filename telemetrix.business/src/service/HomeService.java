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
    private String _currentPage = _defaultPage;
    private String _rootUrl = "/contentViews/";
    private String _pageSuffix = ".xhtml";

    public void setCurrentPage(String pageName) {
        if (pageName == null) {
            return;
        }

        if (pageName.isEmpty()) {
            return;
        }

        _currentPage = urlBuilder(pageName);
    }

    public String getCurrentPage() {
        return _currentPage;
    }

    public String getDefaultPage() {
        return _defaultPage;
    }

    private String urlBuilder(String pageName) {
        String pageUrl = _rootUrl + pageName + _pageSuffix;
        return pageUrl;
    }

}
