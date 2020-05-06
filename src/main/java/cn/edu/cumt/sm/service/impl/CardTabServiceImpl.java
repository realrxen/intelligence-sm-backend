package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.CardTab;
import cn.edu.cumt.sm.dao.CardTabMapper;
import cn.edu.cumt.sm.service.CardTabService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-06
 */
@Service
public class CardTabServiceImpl implements CardTabService {

    @Autowired
    private CardTabMapper cardTabMapper;
    @Override
    public CardTab selectByCardId(String cardId) {
        return cardTabMapper.selectById(cardId);

    }
}
