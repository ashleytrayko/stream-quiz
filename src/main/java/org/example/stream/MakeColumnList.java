package org.example.stream;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MakeColumnList {
    public List<Column> MakeColumnList() {
        //csv파일 읽어옴
        File csvFile = new File("C:\\Users\\User\\Desktop\\CSVconfig.csv");
        List<Column> columnList = null;
        
        //Column 객체에 맞춰 csv파일 파싱
        try {
            columnList = new CsvToBeanBuilder(new FileReader(csvFile))
                    .withSeparator(';')
                    .withType(Column.class)
                    .build()
                    .parse();
            return columnList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
