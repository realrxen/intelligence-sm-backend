package cn.edu.cumt.sm.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class CardBO implements Serializable {

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

    @JsonProperty("name")
    private String cardName;

    private String tabId;






}
