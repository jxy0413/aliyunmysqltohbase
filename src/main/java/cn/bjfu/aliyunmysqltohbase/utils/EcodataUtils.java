package cn.bjfu.aliyunmysqltohbase.utils;

import cn.bjfu.aliyunmysqltohbase.model.Ecodata;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by jxy on 2020/11/15 0015 17:28
 */
@Component
public class EcodataUtils {
    public static Configuration conf;
    private static Admin admin;

    static{
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "Master,Worker1,Worker3,Worker4");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        try {
            Connection connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(String tableName, Ecodata ecodata) throws IOException {
        TableName tablename = TableName.valueOf(tableName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dataTimeMinte = sdf.format(ecodata.getDataTime());
        Put put = new Put((ecodata.getStationId()+"-"+dataTimeMinte).getBytes());
        //参数：1.列族名  2.列名  3.值
        put.addColumn("datatype".getBytes(), (ecodata.getDatatypeId()+"").getBytes(), (ecodata.getDataValue()+"").getBytes()) ;
        //HTable table = new HTable(initHbase().getConfiguration(),tablename);已弃用
        Table table = admin.getConnection().getTable(tablename);
        table.put(put);
    }

}
