package com.mpc.f2;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public class TestCSV {

    public static void main(String[] args) throws Exception{
        InputStream resourceAsStream = TestCSV.class.getResourceAsStream("abc.csv");
        CSVParser parse = CSVParser.parse(resourceAsStream, Charset.forName("UTF-8"), CSVFormat.POSTGRESQL_TEXT);
        List<CSVRecord> records = parse.getRecords();
        CSVRecord csvRecord = records.get(0);
        System.out.println(csvRecord.values()[0]);
    }
}
