package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.CardTab;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-06
 */
public interface CardTabService{

    CardTab selectByCardId(String cardId);

}
