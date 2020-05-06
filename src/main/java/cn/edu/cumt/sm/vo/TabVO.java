package cn.edu.cumt.sm.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TabVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * tab主键id
     */
    @TableId
    private String tabId;

    /**
     * tab名称
     */
    @JsonProperty("name")
    private String tabName;






}
