package cn.edu.cumt.sm.model;

import lombok.Data;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/9 21:54
 */
@Data
public class FileCloud {

    private String name;
    private String url;

    public FileCloud(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
