package com.example.bill.service;

import com.example.bill.entity.BillInfo;
import com.example.bill.param.BillInfoPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 *  服务类
 *
 * @author geekidea
 * @since 2020-05-21
 */
public interface BillInfoService extends BaseService<BillInfo> {

    /**
     * 保存
     *
     * @param billInfo
     * @return
     * @throws Exception
     */
    boolean saveBillInfo(BillInfo billInfo) throws Exception;

    /**
     * 修改
     *
     * @param billInfo
     * @return
     * @throws Exception
     */
    boolean updateBillInfo(BillInfo billInfo) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteBillInfo(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param billInfoQueryParam
     * @return
     * @throws Exception
     */
    Paging<BillInfo> getBillInfoPageList(BillInfoPageParam billInfoPageParam) throws Exception;

    /**
     * description: 获取总净重
     * creat: mal
     * date: 2020/5/21
     */
    int getConNet() throws Exception;

}
