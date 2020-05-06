package cn.edu.cumt.sm.dto;

import cn.edu.cumt.sm.bo.NewsBO;
import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.model.MyPageHelper;
import cn.edu.cumt.sm.vo.CardVO;
import lombok.Data;

import java.util.List;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/3 23:01
 */
@Data
public class NewsDTO {
    private CardVO cardVO;
    private List<NewsBO> newsBOS;
}
