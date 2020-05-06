package cn.edu.cumt.sm.dataobject;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻id
     */
    @TableId
    private String newsId;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻类型
     */
    private Integer type;

    /**
     * 封面图片
     */
    @JsonProperty("cover")
    private String coverPicture;

    /**
     * 摘要
     */
    private String summary;

    /**
     * md内容
     */
    private String mdContent;

    /**
     * html内容
     */
    private String htmlContent;

    /**
     * 审核人员
     */
    private String checker;

    /**
     * 编辑人员
     */
    private String editor;

    /**
     * 摄影人员
     */
    private String photographer;

    /**
     * 是否公示
     */
    private Boolean status;

    /**
     * 浏览次数
     */
    private String watchTimes;

    /**
     * tab表主键
     */
    private Integer tabId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
