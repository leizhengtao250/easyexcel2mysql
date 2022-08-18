package com.hos.excel2mysql.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("hostools")
public class HosTM {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField("s0")
    private String s0;
    @TableField("s1")
    private String s1;
    @TableField("s2")
    private String s2;
    @TableField("s3")
    private String s3;
    @TableField("s4")
    private String s4;
    @TableField("s5")
    private String s5;
    @TableField("s6")
    private String s6;
    @TableField("s7")
    private String s7;
    @TableField("s8")
    private String s8;
    @TableField("s9")
    private String s9;
    @TableField("s10")
    private String s10;
    @TableField("s11")
    private String s11;
    @TableField("s12")
    private String s12;
    @TableField("s13")
    private String s13;
    @TableField("s14")
    private String s14;
    @TableField("s15")
    private String s15;
    @TableField("s16")
    private String s16;
    @TableField("s17")
    private String s17;
    @TableField("s18")
    private String s18;
    @TableField("s19")
    private String s19;
    @TableField("s20")
    private String s20;
    @TableField("s21")
    private String s21;
    @TableField("s22")
    private String s22;
    @TableField("s23")
    private String s23;
    @TableField("s24")
    private String s24;
    @TableField("s25")
    private String s25;
    @TableField("s26")
    private String s26;
}
