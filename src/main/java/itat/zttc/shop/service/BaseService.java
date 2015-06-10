package itat.zttc.shop.service;

import itat.zttc.shop.model.Pager;
import itat.zttc.shop.model.SystemContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * since 2015/6/10.
 */
public abstract class BaseService<T> {

    protected abstract List<T> findList(Map<String, Object> params);

    protected abstract int findCount(Map<String, Object> params);

    public Pager<T> find(Map<String, Object> params) {
        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffset();
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Pager<T> pages = new Pager<T>();
        if (params == null) params = new HashMap<String, Object>();
        params.put("pageSize", pageSize);
        params.put("pageOffset", pageOffset);
        params.put("sort", sort);
        params.put("order", order);
        List<T> datas = findList(params);
        pages.setDatas(datas);
        pages.setPageOffset(pageOffset);
        pages.setPageSize(pageSize);
        int totalRecord = findCount(params);
        pages.setTotalRecord(totalRecord);
        return pages;
    }
}
