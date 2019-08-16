package com.cskaoyan.springboot.demo.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StatData {

    private String[] columns;
    private List<Map> rows;

    public StatData(String[] columns, List<Map> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public StatData() {
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Map> getRows() {
        return rows;
    }

    public void setRows(List<Map> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "StatData{" +
                "columns=" + Arrays.toString(columns) +
                ", rows=" + rows +
                '}';
    }
}
