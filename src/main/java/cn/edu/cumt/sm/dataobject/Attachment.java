package cn.edu.cumt.sm.dataobject;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author Seeumt
 * @since 2020-05-09
 */
@Data
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 附件url
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 状态
     */
    private Boolean status;


}
