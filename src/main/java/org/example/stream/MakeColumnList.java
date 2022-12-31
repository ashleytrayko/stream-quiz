package org.example.stream;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MakeColumnList {
    public List<Column> MakeColumnList() {
        File csvFile = new File("/Users/JAN/Desktop/CSVconfig.csv");
        List<Column> columnList = null;
        try {
            columnList = new CsvToBeanBuilder(new FileReader(csvFile))
                    .withSeparator(';')
                    .withType(Column.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            return columnList;
        }
    }
}
