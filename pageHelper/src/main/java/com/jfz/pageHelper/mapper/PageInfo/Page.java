package com.jfz.pageHelper.mapper.PageInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/17 20:02
 */
@Data
@AllArgsConstructor
public class Page {
    private Integer page = 1;

    private Integer rows = 10;

    private String orderBy;

    public Page(int start, int size) {
        this.page=start;
        this.rows=size;
    }
}
