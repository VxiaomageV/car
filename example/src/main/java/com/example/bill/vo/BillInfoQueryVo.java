package com.example.bill.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *  查询结果对象
 * </pre>
 *
 * @author geekidea
 * @date 2020-05-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "BillInfoQueryVo对象")
public class BillInfoQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("订单编码")
    private String billCode;

    @ApiModelProperty("货物名称")
    private String cargoName;

    @ApiModelProperty("货物规格")
    private String cargoSize;

    @ApiModelProperty("生产单位")
    private String produceCompany;

    @ApiModelProperty("供货单位")
    private String provideCompany;

    @ApiModelProperty("收货单位")
    private String receiveCompany;

    @ApiModelProperty("毛重")
    private Double roughWeight;

    @ApiModelProperty("皮重")
    private Double tareWeight;

    @ApiModelProperty("净重")
    private Double netWeight;

    @ApiModelProperty("方数")
    private Double number;

    @ApiModelProperty("比例")
    private Double proportion;

    @ApiModelProperty("创建人")
    private String createUser;

    @ApiModelProperty("修改人")
    private String updateUser;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}