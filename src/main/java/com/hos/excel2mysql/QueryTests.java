package com.hos.excel2mysql;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.hos.excel2mysql.config.HosTools;
import com.hos.excel2mysql.config.ResultRecord;
import com.hos.excel2mysql.config.YiGuan;
import com.hos.excel2mysql.config.YiGuan;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class QueryTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 根据已贯表中---27位码查询现有耗材表中的所有的数据项
     *
     */
    @Test
    public void insertData4() {
        String sql = "SELECT * FROM yiguanbiao";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> mapsStoreS24 = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < maps.size(); i++) {
            Map<String,Object> map = maps.get(i);
            String s8 = map.get("s8").toString();
            String sqlH = "SELECT * FROM hostools where s26="+"'"+s8+"'";
            List<Map<String, Object>> maps2=jdbcTemplate.queryForList(sqlH);
            mapsStoreS24.addAll(maps2);
        }
        String FilePath = "E:\\code\\数据库资料\\result26.xlsx";
        List<ResultRecord> list = new ArrayList<ResultRecord>();
        for(int j=0;j< mapsStoreS24.size();j++) {
            try {
                Map<String, Object> m = mapsStoreS24.get(j);
                ResultRecord r = new ResultRecord();
                r.setS1(m.get("s1").toString());
                r.setS2(m.get("s2").toString());
                r.setS3(m.get("s3").toString());
                r.setS4(m.get("s4").toString());
                r.setS5(m.get("s5").toString());
                r.setS6(m.get("s6").toString());
                r.setS7(m.get("s7").toString());
                r.setS8(m.get("s8").toString());
                r.setS9(m.get("s9").toString());
                r.setS10(m.get("s10").toString());
                if(m.get("s11")==null){
                    r.setS11("空");
                }else{
                    r.setS11(m.get("s11").toString());
                }
                r.setS12(m.get("s12").toString());
                r.setS13(m.get("s13").toString());
                r.setS14(m.get("s14").toString());
                r.setS15(m.get("s15").toString());
                r.setS16(m.get("s16").toString());
                r.setS17(m.get("s17").toString());
                r.setS18(m.get("s18").toString());
                r.setS19(m.get("s19").toString());
                r.setS20(m.get("s20").toString());
                r.setS21(m.get("s21").toString());
                r.setS22(m.get("s22").toString());
                if(m.get("s23")==null){
                    r.setS23("空");
                }else{
                    r.setS23(m.get("s23").toString());
                }
                if(m.get("s24")==null){
                    r.setS24("空");
                }else{
                    r.setS24(m.get("s24").toString());
                }
                if(m.get("s25")==null){
                    r.setS25("空");
                }else{
                    r.setS25(m.get("s25").toString());
                }
                r.setS26(m.get("s26").toString());
                r.setS27(m.get("s27").toString());
                list.add(r);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        EasyExcel.write(FilePath,ResultRecord.class)
                .sheet("已贯表")
                .doWrite(list);

    }

}
