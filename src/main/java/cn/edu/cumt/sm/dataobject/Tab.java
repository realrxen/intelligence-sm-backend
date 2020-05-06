package cn.edu.cumt.sm.dataobject;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Tab implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * tab主键id
     */
    @TableId
    private String tabId;

    /**
     * tab名称
     */
    private String tabName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否可用
     */
    private Boolean status;


}
