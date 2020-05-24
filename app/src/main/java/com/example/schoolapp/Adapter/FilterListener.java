package com.example.schoolapp.Adapter;

import java.util.List;

/**
 * Created by 帅气的靓仔 on 2017/9/7.
 *  *接口类，抽象方法用来获取过滤后的数据
 */

public interface FilterListener {
    void getFilterData(List<String> list);// 获取过滤后的数据
}
