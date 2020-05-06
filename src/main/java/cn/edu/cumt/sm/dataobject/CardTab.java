package cn.edu.cumt.sm.dataobject;

import java.io.Serializable;

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
public class CardTab implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * card表主键id
     */
    @TableId
    private String cardId;

    /**
     * tab表主键id
     */
    private String tabId;


}
