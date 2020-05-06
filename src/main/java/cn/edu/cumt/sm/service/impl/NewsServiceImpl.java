package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.bo.NewsBO;
import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.dataobject.News;
import cn.edu.cumt.sm.dao.NewsMapper;
import cn.edu.cumt.sm.dto.NewsDTO;
import cn.edu.cumt.sm.model.MyPageHelper;
import cn.edu.cumt.sm.service.CardService;
import cn.edu.cumt.sm.service.MediaTagsService;
import cn.edu.cumt.sm.service.NewsService;
import cn.edu.cumt.sm.service.TagService;
import cn.edu.cumt.sm.vo.CardVO;
import cn.edu.cumt.sm.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private MediaTagsService mediaTagsService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CardService cardService;

    @Override
    public ResultVO listNews(int type,int currentNum, int size) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type).orderByDesc("create_time");
        PageHelper.startPage(currentNum, size);
        List<News> newsList = newsMapper.selectList(queryWrapper);
        PageInfo<News> newsPageInfo = new PageInfo<>(newsList);
        MyPageHelper<NewsBO> myPageHelper = new MyPageHelper<>();
        BeanUtils.copyProperties(newsPageInfo, myPageHelper);
        List<NewsBO> newsBOS = assembleBoList(newsList);
        myPageHelper.setList(newsBOS);
        return ResultVO.success(myPageHelper);
    }

    @Override
    public ResultVO listNews2() {
        List<Card> cards = cardService.listCards();
        List<NewsDTO> newsDTOS = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            NewsDTO newsDTO = new NewsDTO();
            CardVO cardVO = new CardVO();
            BeanUtils.copyProperties(card, cardVO);
            cardVO.setForSort(i);
            newsDTO.setCardVO(cardVO);
            QueryWrapper<News> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("type", card.getSort()).orderByDesc("create_time");
            queryWrapper.last("limit 3");
            List<News> newsList = newsMapper.selectList(queryWrapper);
            List<NewsBO> newsBOS = assembleBoList(newsList);
            newsDTO.setNewsBOS(newsBOS);
            newsDTOS.add(newsDTO);
        }
        for (NewsDTO newsDTO : newsDTOS) {
            if (newsDTO.getNewsBOS().size() == 0 && (newsDTO.getCardVO().getForSort() + 1) == cards.size()) {
                newsDTOS.get(cards.size() - 2).getCardVO().setIsLast(true);
            }
        }
        return ResultVO.success(newsDTOS);

    }

    public List<NewsBO> assembleBoList(List<News> newsList) {
        return newsList.stream().map(news -> {
            NewsBO newsBO = new NewsBO();
            BeanUtils.copyProperties(news, newsBO);
            List<String> tagsIds = mediaTagsService.findTagIdsByParentId(news.getNewsId());
            if (tagsIds.size() == 0) {
                newsBO.setTags(null);
            }else {
                newsBO.setTags(tagService.findTagVoByTagIds(tagsIds));
            }
            return newsBO;
        }).collect(Collectors.toList());
    }

}
