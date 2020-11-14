package com.hao.spring.transaction.service;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <code>InsuranceDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-11-06
 * @version: 1.0
 */
@Data
public class InsuranceDemo {

    private Integer id;

    private String name;

    private String productCode;

    private String productName;

    private BigDecimal amount;

    private Date createTime;

    private String remark;

    private String textData;

    private byte[] blobData;

    private Integer isDelete;
}
