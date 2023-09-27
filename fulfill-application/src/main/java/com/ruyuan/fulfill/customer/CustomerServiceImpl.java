package com.ruyuan.fulfill.customer;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ruyuan.fulfill.api.CustomerServiceI;
import com.ruyuan.fulfill.customer.executor.CustomerAddCmdExe;
import com.ruyuan.fulfill.customer.executor.query.CustomerListByNameQryExe;
import com.ruyuan.fulfill.dto.CustomerAddCmd;
import com.ruyuan.fulfill.dto.CustomerListByNameQry;
import com.ruyuan.fulfill.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}