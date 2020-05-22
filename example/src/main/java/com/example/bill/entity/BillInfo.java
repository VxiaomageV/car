package com.example.bill.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;

/**
 * 
 *
 * @author geekidea
 * @since 2020-05-21
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BillInfo对象")
public class BillInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
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
