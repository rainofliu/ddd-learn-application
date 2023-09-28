package com.ruyuan.fulfill.infrastructure.gatewayimpl.database;

import com.ruyuan.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ly
 */
@Mapper
public interface FulfillOrderMapper {

    int create(FulfillOrderDO fulfillOrderDO);
}
