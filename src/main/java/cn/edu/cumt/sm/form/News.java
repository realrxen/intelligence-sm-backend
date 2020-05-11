package cn.edu.cumt.sm.form;

import lombok.Data;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/9 23:41
 */
@Data
public class News {

    private String title;
    private String author;
    private String summary;
    private String coverPicture;
    private String type;
    private String content;
    private String tags;
    private Object files;

}
