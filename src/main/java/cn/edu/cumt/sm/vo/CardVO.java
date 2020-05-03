package cn.edu.cumt.sm.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
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
public class CardVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * card主键
     */

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
     * 卡片名称
     */
    private String name;

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


    @JsonIgnore
    private Integer forSort;

    private Boolean status;






}
