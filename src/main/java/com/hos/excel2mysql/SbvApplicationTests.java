package com.hos.excel2mysql;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.util.ListUtils;
import com.hos.excel2mysql.config.HosTools;
import com.hos.excel2mysql.config.YiGuan;
import com.hos.excel2mysql.mapper.HosToolsMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SbvApplicationTests {
    @Autowired
    private HosToolsMapper hosToolsMapper;
    @Autowired
    DataSource dataSource;

    private long id = 0;


    @Test
    public void getPath() {
        String path = "F:\\hos\\医保医用耗材代码_C";
        for (int i = 1; i <= 17; i++) {
            String pathT = path + i;
            File fileJ = new File(pathT);
            String[] files = fileJ.list();
            for (int j = 0; j < files.length; j++) {
                if (files[j].toString().contains("单件")) {
                    System.out.println(pathT + files[j].toString());
                }
            }
        }
    }

    /**
     * 耗材数据整体插入到一张表
     * @throws SQLException
     */
    @Test
    public void insertData() throws SQLException {

        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        Logger log = LoggerFactory.getLogger(SbvApplicationTests.class);

        String path = "F:\\hos\\医保医用耗材代码_C";
        for (int i = 1; i <= 17; i++) {
            String pathT = path + i;
            File fileJ = new File(pathT);
            String[] files = fileJ.list();
            for (int j = 0; j < files.length; j++) {
                if (files[j].toString().contains("单件")) {
                    String fileName = pathT + "\\" + files[j].toString();
                    EasyExcel.read(fileName, HosTools.class, new ReadListener<HosTools>() {

                        /**
                         * 单词缓存的数据量
                         */
                        public static final int BATCH_COUNT = 10000;

                        /**
                         *临时存储
                         */
                        private List<HosTools> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


                        @SneakyThrows
                        @Override
                        public void invoke(HosTools data, AnalysisContext context) {
                            cachedDataList.add(data);
                            if (cachedDataList.size() >= BATCH_COUNT) {
                                saveData();
                                cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                            }
                        }

                        @SneakyThrows
                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {
                            saveData();
                            log.info(fileName + "所有数据解析完成！");
                        }

                        private void saveData() {

                            try {


                                PreparedStatement pstm = null;
                                String sql = "INSERT INTO hostools VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                pstm = conn.prepareStatement(sql);
                                for (int i = 0; i < cachedDataList.size(); i++) {
                                    id = id + 1;
                                    pstm.setString(1, cachedDataList.get(i).getS1());
                                    pstm.setString(2, cachedDataList.get(i).getS2());
                                    pstm.setString(3, cachedDataList.get(i).getS3());
                                    pstm.setString(4, cachedDataList.get(i).getS4());
                                    pstm.setString(5, cachedDataList.get(i).getS5());
                                    pstm.setString(6, cachedDataList.get(i).getS6());
                                    pstm.setString(7, cachedDataList.get(i).getS7());
                                    pstm.setString(8, cachedDataList.get(i).getS8());
                                    pstm.setString(9, cachedDataList.get(i).getS9());
                                    pstm.setString(10, cachedDataList.get(i).getS10());
                                    pstm.setString(11, cachedDataList.get(i).getS11());
                                    pstm.setString(12, cachedDataList.get(i).getS12());
                                    pstm.setString(13, cachedDataList.get(i).getS13());
                                    pstm.setString(14, cachedDataList.get(i).getS14());
                                    pstm.setString(15, cachedDataList.get(i).getS15());
                                    pstm.setString(16, cachedDataList.get(i).getS16());
                                    pstm.setString(17, cachedDataList.get(i).getS17());
                                    pstm.setString(18, cachedDataList.get(i).getS18());
                                    pstm.setString(19, cachedDataList.get(i).getS19());
                                    pstm.setString(20, cachedDataList.get(i).getS20());
                                    pstm.setString(21, cachedDataList.get(i).getS21());
                                    pstm.setString(22, cachedDataList.get(i).getS22());
                                    pstm.setString(23, cachedDataList.get(i).getS23());
                                    pstm.setString(24, cachedDataList.get(i).getS24());
                                    pstm.setString(25, cachedDataList.get(i).getS25());
                                    pstm.setString(26, cachedDataList.get(i).getS26());
                                    pstm.setString(27, cachedDataList.get(i).getS27());
                                    pstm.setLong(28, id);
                                    pstm.addBatch();
                                }
                                pstm.executeBatch();

                                conn.commit();
                            } catch (Exception e) {
                                log.info(fileName + "------->" + id + ":" + e);
                            }

                        }
                    }).sheet().doRead();
                }
            }
        }
        conn.close();
    }


    /**
     * 测试耗材插入
     * @throws SQLException
     */
    @Test
    public void insertData2() throws SQLException {

        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        Logger log = LoggerFactory.getLogger(SbvApplicationTests.class);

        String fileName = "F:\\hos\\医保医用耗材代码_C1\\医保医用耗材代码_C01_非血管介入治疗类材料_单件及规格型号信息.xlsx";
        EasyExcel.read(fileName, HosTools.class, new ReadListener<HosTools>() {

            /**
             * 单词缓存的数据量
             */
            public static final int BATCH_COUNT = 10000;

            /**
             *临时存储
             */
            private List<HosTools> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


            @SneakyThrows
            @Override
            public void invoke(HosTools data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @SneakyThrows
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
                log.info(fileName + "所有数据解析完成！");
            }

            private void saveData() {


                PreparedStatement pstm = null;
                String sql = "INSERT INTO hostools VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                    pstm = conn.prepareStatement(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < cachedDataList.size(); i++) {
                    id = id + 1;
                    try {
                        pstm.setString(1, cachedDataList.get(i).getS1());
                        pstm.setString(2, cachedDataList.get(i).getS2());
                        pstm.setString(3, cachedDataList.get(i).getS3());
                        pstm.setString(4, cachedDataList.get(i).getS4());
                        pstm.setString(5, cachedDataList.get(i).getS5());
                        pstm.setString(6, cachedDataList.get(i).getS6());
                        pstm.setString(7, cachedDataList.get(i).getS7());
                        pstm.setString(8, cachedDataList.get(i).getS8());
                        pstm.setString(9, cachedDataList.get(i).getS9());
                        pstm.setString(10, cachedDataList.get(i).getS10());
                        pstm.setString(11, cachedDataList.get(i).getS11());
                        pstm.setString(12, cachedDataList.get(i).getS12());
                        pstm.setString(13, cachedDataList.get(i).getS13());
                        pstm.setString(14, cachedDataList.get(i).getS14());
                        pstm.setString(15, cachedDataList.get(i).getS15());
                        pstm.setString(16, cachedDataList.get(i).getS16());
                        pstm.setString(17, cachedDataList.get(i).getS17());
                        pstm.setString(18, cachedDataList.get(i).getS18());
                        pstm.setString(19, cachedDataList.get(i).getS19());
                        pstm.setString(20, cachedDataList.get(i).getS20());
                        pstm.setString(21, cachedDataList.get(i).getS21());
                        pstm.setString(22, cachedDataList.get(i).getS22());
                        pstm.setString(23, cachedDataList.get(i).getS23());
                        pstm.setString(24, cachedDataList.get(i).getS24());
                        pstm.setString(25, cachedDataList.get(i).getS25());
                        pstm.setString(26, cachedDataList.get(i).getS26());
                        pstm.setString(27, cachedDataList.get(i).getS27());
                        pstm.setLong(28, id);
                        pstm.addBatch();
                    } catch (Exception e) {
                        log.info(fileName + ":" + cachedDataList.get(i).getS1() + "-------" + e);
                    }
                }
                try {
                    pstm.executeBatch();
                    conn.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).sheet().doRead();
        conn.close();
    }


    /**
     * 已贯标耗材表的插入
     */
    @Test
    public void insertData3() throws SQLException {
        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        Logger log = LoggerFactory.getLogger(SbvApplicationTests.class);
        String fileName = "E:\\code\\数据库资料\\已贯标耗材(1).xls";
        EasyExcel.read(fileName, YiGuan.class, new ReadListener<YiGuan>() {

            /**
             * 单词缓存的数据量
             */
            public static final int BATCH_COUNT = 10000;

            /**
             *临时存储
             */
            private List<YiGuan> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


            @SneakyThrows
            @Override
            public void invoke(YiGuan data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @SneakyThrows
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
                log.info(fileName + "所有数据解析完成！");
            }

            private void saveData() {


                PreparedStatement pstm = null;
                String sql = "INSERT INTO yiguanbiao VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                    pstm = conn.prepareStatement(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < cachedDataList.size(); i++) {
                    id = id + 1;
                    try {
                        pstm.setString(1, cachedDataList.get(i).getS1());
                        pstm.setString(2, cachedDataList.get(i).getS2());
                        pstm.setString(3, cachedDataList.get(i).getS3());
                        pstm.setString(4, cachedDataList.get(i).getS4());
                        pstm.setString(5, cachedDataList.get(i).getS5());
                        pstm.setString(6, cachedDataList.get(i).getS6());
                        pstm.setString(7, cachedDataList.get(i).getS7());
                        pstm.setString(8, cachedDataList.get(i).getS8());
                        pstm.setString(9, cachedDataList.get(i).getS9());
                        pstm.setString(10, cachedDataList.get(i).getS10());
                        pstm.setString(11, cachedDataList.get(i).getS11());
                        pstm.setString(12, cachedDataList.get(i).getS12());
                        pstm.setString(13, cachedDataList.get(i).getS13());
                        pstm.setString(14, cachedDataList.get(i).getS14());
                        pstm.setString(15, cachedDataList.get(i).getS15());
                        pstm.setString(16, cachedDataList.get(i).getS16());
                        pstm.setLong(17, id);
                        pstm.addBatch();
                    } catch (Exception e) {
                        log.info(fileName + ":" + cachedDataList.get(i).getS1() + "-------" + e);
                    }
                }
                try {
                    pstm.executeBatch();
                    conn.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).sheet().doRead();
    }

    @Test
    public void testMap(){

        Map<String,String> m = new HashMap<String,String>();
        m.put("a","A");
        m.put("b","B");
        m.put("c","C");
        m.put("d","D");
        System.out.println(m.values());


    }





}



