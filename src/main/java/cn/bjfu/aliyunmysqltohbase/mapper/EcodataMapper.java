package cn.bjfu.aliyunmysqltohbase.mapper;

import cn.bjfu.aliyunmysqltohbase.model.Ecodata;
import cn.bjfu.aliyunmysqltohbase.model.Index;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jxy on 2020/11/15 0015 17:24
 */
@Mapper
public interface EcodataMapper {

    @Select("select * from ecodata where datanum_id=#{datanumId}")
    public Ecodata get(Long datanumId);

    @Select("select * from ecodata where station_id=#{stationId} and datatype_id=#{datatypeId} ")
    List<Ecodata> getList(Integer stationId, Integer datatypeId);

    @Select("select max(e.datanum_id) from  ecodata e")
    Long maxDatanumId();

    @Select("select * from `index` i ORDER BY id DESC limit 1")
    public Index  getIndex();

    @Insert("insert into index values(#{index.start},#{index.end})")
    void insert(Index index);
}