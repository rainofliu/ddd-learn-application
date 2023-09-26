package com.ruyuan.fulfill.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ruyuan.fulfill.dto.CustomerAddCmd;
import com.ruyuan.fulfill.dto.CustomerListByNameQry;
import com.ruyuan.fulfill.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
