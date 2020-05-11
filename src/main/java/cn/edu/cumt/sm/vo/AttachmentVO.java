package cn.edu.cumt.sm.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Seeumt
 * @since 2020-05-09
 */
@Data
public class AttachmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 附件url
     */
    private String url;


    /**
     * 父级id
     */
    private String parentId;


}
