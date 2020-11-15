package cn.bjfu.aliyunmysqltohbase.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by jxy on 2020/11/15 0015 17:23
 */
@Data
@ToString
public class Ecodata {
    private Long datanumId;
    private Integer stationId;
    private Integer deviceId;
    private Integer datatypeId;
    private Date dataTime;
    private Double dataValue;
    private Integer exceptionFlag;
}
