package com.example.bill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bill.entity.BillInfo;
import com.example.bill.service.BillInfoService;
import lombok.extern.slf4j.Slf4j;
import com.example.bill.param.BillInfoPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  控制器
 *
 * @author geekidea
 * @since 2020-05-21
 */
@Slf4j
@RestController
@RequestMapping("/billInfo")
@Module("bill")
@Api(value = "API", tags = {""})
public class BillInfoController extends BaseController {

    @Autowired
    private BillInfoService billInfoService;

    /**
     * 添加
     */
    @PostMapping("/add")
    @OperationLog(name = "添加", type = OperationLogType.ADD)
    @ApiOperation(value = "添加", response = ApiResult.class)
    public ApiResult<Boolean> addBillInfo(@Validated(Add.class) @RequestBody BillInfo billInfo) throws Exception {
        boolean flag = billInfoService.saveBillInfo(billInfo);
        return ApiResult.result(flag);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @OperationLog(name = "修改", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改", response = ApiResult.class)
    public ApiResult<Boolean> updateBillInfo(@Validated(Update.class) @RequestBody BillInfo billInfo) throws Exception {
        boolean flag = billInfoService.updateBillInfo(billInfo);
        return ApiResult.result(flag);
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除", response = ApiResult.class)
    public ApiResult<Boolean> deleteBillInfo(@PathVariable("id") Long id) throws Exception {
        boolean flag = billInfoService.deleteBillInfo(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "详情", type = OperationLogType.INFO)
    @ApiOperation(value = "详情", response = BillInfo.class)
    public ApiResult<BillInfo> getBillInfo(@PathVariable("id") Long id) throws Exception {
        BillInfo billInfo = billInfoService.getById(id);
        return ApiResult.ok(billInfo);
    }

    /**
     * 分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "分页列表", response = BillInfo.class)
    public ApiResult<Paging<BillInfo>> getBillInfoPageList(@Validated @RequestBody BillInfoPageParam billInfoPageParam) throws Exception {
        Paging<BillInfo> paging = billInfoService.getBillInfoPageList(billInfoPageParam);
        return ApiResult.ok(paging);
    }

    /**
     * description: 获取总净重
     * creat: mal
     * date: 2020/5/21
     */
    @GetMapping("/getConNet")
    @OperationLog(name = "获取总净重", type = OperationLogType.OTHER)
    @ApiOperation(value = "获取总净重", response = Double.class)
    public ApiResult<Integer> getConNet() throws Exception{
        return ApiResult.ok(billInfoService.getConNet());
    }

    /**
     * description: 获取总净重
     * creat: mal
     * date: 2020/5/21
     */
    @GetMapping("/getConNetDate")
    @OperationLog(name = "获取每天总净重", type = OperationLogType.OTHER)
    @ApiOperation(value = "获取每天总净重", response = Double.class)
    public ApiResult<Object> getConNetDate() throws Exception{
        QueryWrapper<BillInfo> queryWrapper = new QueryWrapper<BillInfo>();
        queryWrapper.select("sum(net_weight) as total");
        Map<String, Object> map = billInfoService.getMap(queryWrapper);
        return ApiResult.ok(map.get("total"));
    }

}

