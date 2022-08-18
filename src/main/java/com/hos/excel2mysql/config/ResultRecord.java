package com.hos.excel2mysql.config;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ResultRecord {

    @ExcelProperty("product_id")
    private String s1;
    @ExcelProperty("goods_id")
    private String s2;
    @ExcelProperty("regcard_id")
    private String s3;
    @ExcelProperty("医保耗材分类代码")
    private String s4;
    @ExcelProperty("耗材代码")
    private String s5;
    @ExcelProperty("一级分类")
    private String s6;
    @ExcelProperty("二级分类")
    private String s7;
    @ExcelProperty("三级分类")
    private String s8;
    @ExcelProperty("医保通用名")
    private String s9;
    @ExcelProperty("材质")
    private String s10;
    @ExcelProperty("计量单位")
    private String s11;
    @ExcelProperty("是否为一次性耗材")
    private String s12;
    @ExcelProperty("是否灭菌")
    private String s13;
    @ExcelProperty("是否为植介入类")
    private String s14;
    @ExcelProperty("特征")
    private String s15;
    @ExcelProperty("注册备案号")
    private String s16;
    @ExcelProperty("注册备案产品名称")
    private String s17;
    @ExcelProperty("单件产品名称")
    private String s18;
    @ExcelProperty("耗材企业")
    private String s19;
    @ExcelProperty("注册备案人")
    private String s20;
    @ExcelProperty("规格")
    private String s21;
    @ExcelProperty("型号")
    private String s22;
    @ExcelProperty("UDI")
    private String s23;
    @ExcelProperty("原27位码")
    private String s24;
    @ExcelProperty("原码状态")
    private String s25;
    @ExcelProperty("27位码")
    private String s26;
    @ExcelProperty("类型")
    private String s27;








}
