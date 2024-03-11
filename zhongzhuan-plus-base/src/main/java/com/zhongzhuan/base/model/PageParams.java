package com.zhongzhuan.base.model;

import io.swagger.annotations.ApiModelProperty;

/** 分页查询的参数 **/
public class PageParams {
    @ApiModelProperty("页码")
    //当前页码
    private Long pageNo = 1L;

    @ApiModelProperty("每页记录数")
    //每页记录数默认值
    private Long pageSize =10L;


    public PageParams(){

    }

    public PageParams(long pageNo,long pageSize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
