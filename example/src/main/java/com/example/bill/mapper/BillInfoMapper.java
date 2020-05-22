package com.example.bill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bill.entity.BillInfo;
import com.example.bill.param.BillInfoPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 *  Mapper 接口
 *
 * @author geekidea
 * @since 2020-05-21
 */
@Repository
public interface BillInfoMapper extends BaseMapper<BillInfo> {

    /**
     * description: 获取总净重
     * creat: mal
     * date: 2020/5/21
     */
    public int getConNet();


}
