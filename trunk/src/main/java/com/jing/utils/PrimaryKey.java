package com.jing.utils;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * @Description: 主键
 * @modifyBy EX-LIFENG001
 * @modifyDate 2013-3-20 下午04:02:29
 */
public class PrimaryKey {
	
    /**
     * @Description: TODO 
     * @author EX-LIFENG001
     * @date 2013-3-20下午04:02:40
     * @return String
     */
    public static synchronized String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    private static int seq = 0;

    private static final int MAX = 99;

    //短信计数器
    private static int smsSeq = 1;
    private static int smsSeqMax = 9999;

    /**
     * 时间格式生成序列
     * 
     * @return String
     */
    public static synchronized String getCustNo() {
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        FieldPosition HELPER_POSITION = new FieldPosition(0);
        Format dateFormat = new SimpleDateFormat("yyMMddHHmmssS");
        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);

        NumberFormat numberFormat = new DecimalFormat("00");
        numberFormat.format(seq, sb, HELPER_POSITION);

        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }
        return "C" + sb.toString();
    }
    
    public static synchronized String getHxNo() {
    	Format dateFormat = new SimpleDateFormat("yyMMdd HHmmss");
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        FieldPosition helperP = new FieldPosition(0);
        dateFormat.format(rightNow.getTime(), sb, helperP);

        NumberFormat nf = new DecimalFormat("000");
        nf.format(smsSeq, sb, helperP);

        if (smsSeq == smsSeqMax) {
            smsSeq = 1;
        } else {
            smsSeq++;
        }
        return sb.toString().replaceFirst(" ", ""); 
    }
    
    public static synchronized int getNo() {
    	Format dateFormat = new SimpleDateFormat("ddHHmmss");
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        FieldPosition helperP = new FieldPosition(0);
        dateFormat.format(rightNow.getTime(), sb, helperP);

        NumberFormat nf = new DecimalFormat("0");
        nf.format(smsSeq, sb, helperP);

        if (smsSeq == smsSeqMax) {
            smsSeq = 1;
        } else {
            smsSeq++;
        }
        return Integer.parseInt(sb.toString().replaceFirst(" ", "")); 
    }

    /**
     * 短信ID，最长为19位，不能以0开头的正整数。每条短信的requestID都不能重复
     * @Description: TODO 
     * @author ex-chenweiqing
     * @date 2013-4-15下午05:36:47
     * @return String
     */
    public static synchronized String getSMSRequestID() {
        Format dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        FieldPosition helperP = new FieldPosition(0);
        dateFormat.format(rightNow.getTime(), sb, helperP);

        NumberFormat nf = new DecimalFormat("0000");
        nf.format(smsSeq, sb, helperP);

        if (smsSeq == smsSeqMax) {
            smsSeq = 1;
        } else {
            smsSeq++;
        }

        return sb.toString().replaceFirst(" ", "");
    }
    
    /**
     * 事件编码
     * @Description: TODO 
     * @author ex-chenweiqing
     * @date 2013-4-15下午05:36:47
     * @return String
     */
    public static synchronized String getEventNo() {
        Format dateFormat = new SimpleDateFormat("yyMMdd HHmm");
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        FieldPosition helperP = new FieldPosition(0);
        dateFormat.format(rightNow.getTime(), sb, helperP);

        NumberFormat nf = new DecimalFormat("000");
        nf.format(smsSeq, sb, helperP);

        if (smsSeq == smsSeqMax) {
            smsSeq = 1;
        } else {
            smsSeq++;
        }

        return "T"+sb.toString().replaceFirst(" ", "");
    }

    public static void main(String[] args) {
        	System.out.println(PrimaryKey.getEventNo());
    }
}