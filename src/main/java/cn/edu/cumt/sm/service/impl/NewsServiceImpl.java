package cn.edu.cumt.sm.service.impl;
import java.util.Date;

import cn.edu.cumt.sm.bo.CardBO;
import cn.edu.cumt.sm.bo.NewsBO;
import cn.edu.cumt.sm.dao.AttachmentMapper;
import cn.edu.cumt.sm.dataobject.*;
import cn.edu.cumt.sm.dao.NewsMapper;
import cn.edu.cumt.sm.dto.NewsDTO;
import cn.edu.cumt.sm.exception.SmException;
import cn.edu.cumt.sm.model.MyPageHelper;
import cn.edu.cumt.sm.service.*;
import cn.edu.cumt.sm.utils.UuidUtil;
import cn.edu.cumt.sm.vo.AttachmentVO;
import cn.edu.cumt.sm.vo.CardVO;
import cn.edu.cumt.sm.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Splitter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private CardTabService cardTabService;
    @Autowired
    private TabService tabService;
    @Autowired
    private AttachmentService attachmentService;


    @Override
    public ResultVO listNews(String tabId,int currentNum, int size) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tab_id", tabId)
                .orderByDesc("create_time")
                .eq("status",true);
        PageHelper.startPage(currentNum, size);
        List<News> newsList = newsMapper.selectList(queryWrapper);
        PageInfo<News> newsPageInfo = new PageInfo<>(newsList);
        MyPageHelper<NewsBO> myPageHelper = new MyPageHelper<>();
        BeanUtils.copyProperties(newsPageInfo, myPageHelper);
        List<NewsBO> newsBOS = assembleNewsBoList(newsList);
        myPageHelper.setList(newsBOS);
        return ResultVO.success(myPageHelper);
    }

    @Override
    public ResultVO listNews2() {
        List<Card> cards = cardService.listCards();
        List<NewsDTO> newsDTOS = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            CardBO cardBO = new CardBO();
            BeanUtils.copyProperties(card, cardBO);
            NewsDTO newsDTO = new NewsDTO();
            CardTab cardTab = cardTabService.selectByCardId(card.getCardId());
            String tabId = cardTab.getTabId();
            cardBO.setTabId(tabId);
            Tab tab = tabService.selectByTabId(tabId);
            cardBO.setCardName(tab.getTabName());
            CardVO cardVO = new CardVO();
            BeanUtils.copyProperties(cardBO, cardVO);
            cardVO.setForSort(i);
            newsDTO.setCardVO(cardVO);
            QueryWrapper<News> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("tab_id", tab.getTabId()).orderByDesc("create_time").eq("status",true);
            queryWrapper.last("limit 3");
                List<News> newsList = newsMapper.selectList(queryWrapper);
            List<NewsBO> newsBOS = assembleNewsBoList(newsList);
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

    @Override
    @Transactional
    public ResultVO create(cn.edu.cumt.sm.form.News newsForm) {
        String newsId = UuidUtil.getUuid();
        News news = new News();
        news.setNewsId(newsId);
        news.setTitle(newsForm.getTitle());
        news.setCoverPicture(newsForm.getCoverPicture());
        news.setSummary(newsForm.getSummary());
        news.setMdContent("");
        news.setHtmlContent(newsForm.getContent());
        news.setChecker("");
        news.setAuthor(newsForm.getAuthor());
        news.setPhotographer("");
        news.setStatus(true);
        news.setWatchTimes(0);
        news.setTabId(newsForm.getType());
        news.setCreateTime(new Date());
        news.setUpdateTime(new Date());
        int insert = newsMapper.insert(news);
        if (insert < 0 ) {
            throw new SmException(10001, "文章插入失败");
        }
        if (newsForm.getFiles() != null) {
            JSONArray jsonArray = JSONArray.fromObject(newsForm.getFiles());
                addAttachments(jsonArray, newsId);
        }
        List<String> tagIdList = Splitter.on(",").splitToList(newsForm.getTags());
        if (CollectionUtils.isNotEmpty(tagIdList)) {
            mediaTagsService.insert(tagIdList,newsId);
        }
        return ResultVO.success("发布成功！");
    }

    public void addAttachments(JSONArray attachments, String parentId) {

        for (int i = 0; i < attachments.size(); i++) {
            Attachment attachment = new Attachment();
            attachment.setId(UuidUtil.getUuid());
            attachment.setName((String) attachments.getJSONObject(i).get("name"));
            attachment.setUrl((String) attachments.getJSONObject(i).get("url"));
            attachment.setCreateTime(new Date());
            attachment.setUpdateTime(new Date());
            attachment.setParentId(parentId);
            attachment.setStatus(true);
            attachmentService.insertAttachment(attachment);
        }

    }





    public List<NewsBO> assembleNewsBoList(List<News> newsList) {
        return newsList.stream().map(news -> {
            NewsBO newsBO = new NewsBO();
            BeanUtils.copyProperties(news, newsBO);
            List<String> tagsIds = mediaTagsService.findTagIdsByParentId(news.getNewsId());
            if (tagsIds.size() == 0) {
                newsBO.setTags(null);
            }else {
                newsBO.setTags(tagService.findTagVoByTagIds(tagsIds));
            }
            List<AttachmentVO> attachmentVOS = attachmentService.selectAttachmentVosByParentId(news.getNewsId());
            newsBO.setAttachments(attachmentVOS);
            return newsBO;
        }).collect(Collectors.toList());
    }

}
