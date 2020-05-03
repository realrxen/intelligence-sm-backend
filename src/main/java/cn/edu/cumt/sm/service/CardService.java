package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.vo.ResultVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
public interface CardService extends IService<Card> {

    List<Card> listCards();


}
