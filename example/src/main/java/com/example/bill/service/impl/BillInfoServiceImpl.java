package com.example.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bill.entity.BillInfo;
import com.example.bill.mapper.BillInfoMapper;
import com.example.bill.service.BillInfoService;
import com.example.bill.param.BillInfoPageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author geekidea
 * @since 2020-05-21
 */
@Slf4j
@Service
public class BillInfoServiceImpl extends BaseServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {

    @Autowired
    private BillInfoMapper billInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBillInfo(BillInfo billInfo) throws Exception {
        return super.save(billInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBillInfo(BillInfo billInfo) throws Exception {
        return super.updateById(billInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteBillInfo(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<BillInfo> getBillInfoPageList(BillInfoPageParam billInfoPageParam) throws Exception {
        Page<BillInfo> page = new PageInfo<>(billInfoPageParam, OrderItem.desc(getLambdaColumn(BillInfo::getCreateTime)));
        LambdaQueryWrapper<BillInfo> wrapper = new LambdaQueryWrapper<>();
        IPage<BillInfo> iPage = billInfoMapper.selectPage(page, wrapper);
        return new Paging<BillInfo>(iPage);
    }

    /**
     * description: 获取总净重
     * creat: mal
     * date: 2020/5/21
     */
    @Override
    public int getConNet() throws Exception {
        return billInfoMapper.getConNet();
    }

}
