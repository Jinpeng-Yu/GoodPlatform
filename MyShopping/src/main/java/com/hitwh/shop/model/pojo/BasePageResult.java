package com.hitwh.shop.model.pojo;

import com.hitwh.shop.model.pojo.BaseResult;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName BasePageResult
 * @Description 用来封装分页结果,只显示必要的属性,首页为1往后每页加1
 * @Author 孙一恒
 * @Date 2019/6/16 9:23
 * @Version 1.0
 **/
public class BasePageResult<T> extends BaseResult<T> {
    private int pageNo; // 页号
    private int pageSize; // 每页大小
    private int totalPages; // 总页数
    private long totalElement; // 总个数
    private List content;

    public BasePageResult() {
    }

    public BasePageResult(String message, boolean success, T data, Page page) {
        this.construct(success, message, data);
        this.totalPages = page.getTotalPages();
        this.pageNo= page.getNumber();
        this.totalElement = page.getTotalElements();
        this.pageSize = page.getSize();
        this.content = page.getContent();
    }

    public void construct(boolean success, String message, T data, Page page){
        this.construct(success, message, data);
        this.totalPages = page.getTotalPages();
        this.pageNo= page.getNumber();
        this.totalElement = page.getTotalElements();
        this.pageSize = page.getSize();
        this.content = page.getContent();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
