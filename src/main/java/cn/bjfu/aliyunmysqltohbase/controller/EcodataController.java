package cn.bjfu.aliyunmysqltohbase.controller;

import cn.bjfu.aliyunmysqltohbase.service.EcodataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jxy on 2020/11/15 0015 17:31
 */
@RestController
public class EcodataController {
    @Autowired
    private EcodataService ecodataService;

    @ApiOperation("mysqlToHbase")
    @RequestMapping("/mysqlToHbase")
    public void mysqlToHbase() throws Exception{
        ecodataService.mysqlToHbase();
    }
}
