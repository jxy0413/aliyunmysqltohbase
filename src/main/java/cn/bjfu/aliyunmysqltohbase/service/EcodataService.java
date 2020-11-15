package cn.bjfu.aliyunmysqltohbase.service;

import cn.bjfu.aliyunmysqltohbase.mapper.EcodataMapper;
import cn.bjfu.aliyunmysqltohbase.model.Ecodata;
import cn.bjfu.aliyunmysqltohbase.utils.EcodataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jxy on 2020/11/15 0015 17:27
 */
@Service
public class EcodataService {
    @Autowired
    private EcodataUtils utils;
    @Autowired
    private EcodataMapper ecodataMapper;
    public void mysqlToHbase() throws Exception {
        for(long i=63767064;i<=84312963L;i++){
            Ecodata ecodata = ecodataMapper.get(i);
            if(ecodata!=null){
                System.out.println(i);
                utils.insertData("EcodataJxy",ecodata);
            }
        }
    }
    public void mysqlToHbase(Long start,Long end) throws Exception{
        for(long i=start;i<=end;i++){
            Ecodata ecodata = ecodataMapper.get(i);
            if(ecodata!=null){
                System.out.println(i);
                utils.insertData("EcodataJxy",ecodata);
            }
        }
    }
}
