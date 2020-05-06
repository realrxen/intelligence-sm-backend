package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.dao.CardMapper;
import cn.edu.cumt.sm.service.CardService;
import cn.edu.cumt.sm.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements CardService {

    @Autowired
    private CardMapper cardMapper;
    @Override
    public List<Card> listCards() {
        QueryWrapper<Card> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort").eq("status",true);
        List<Card> list = cardMapper.selectList(queryWrapper);
        return list;
    }
}
