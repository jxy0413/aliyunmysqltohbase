package cn.bjfu.aliyunmysqltohbase.time;

import cn.bjfu.aliyunmysqltohbase.mapper.EcodataMapper;
import cn.bjfu.aliyunmysqltohbase.model.Index;
import cn.bjfu.aliyunmysqltohbase.service.EcodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by jxy on 2020/11/15 0015 18:13
 */
public class EcodataTiming {
    @Autowired
    private EcodataMapper ecodataMapper;
    @Autowired
    private EcodataService ecodataService;

    @Scheduled(cron = "0 0 * * * ?")
    public void mysqlToHbase() throws Exception{
        Long maxId = ecodataMapper.maxDatanumId();
        Index index = ecodataMapper.get();
        //先插入mysql
        Index newIndex = new Index();
        newIndex.setStart(index.getEnd());
        newIndex.setEnd(maxId);
        ecodataMapper.insert(newIndex);
        //开始执行
        ecodataService.mysqlToHbase(index.getEnd(),maxId);
    }
}
