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
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * card主键
     */
    @TableId
    private String cardId;

    /**
     * 是否为第一个card
     */
    private Boolean isFirst;

    /**
     * 是否为最后一个card
     */
    private Boolean isLast;

    /**
     * 卡片图标
     */
    private String icon;

    /**
     * 卡片图标颜色
     */
    private String color;

    /**
     * 卡片顺序
     */
    @JsonProperty("order")
    private Integer sort;

    /**
     * 卡片状态
     */
    private Boolean status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
