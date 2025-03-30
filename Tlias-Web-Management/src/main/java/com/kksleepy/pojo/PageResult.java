package com.kksleepy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询返回封装数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private long total;
    private List<T> rows;
}
