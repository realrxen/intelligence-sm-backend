package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.MediaTags;
import cn.edu.cumt.sm.dao.MediaTagsMapper;
import cn.edu.cumt.sm.exception.SmException;
import cn.edu.cumt.sm.service.MediaTagsService;
import cn.edu.cumt.sm.utils.UuidUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-03
 */
@Service
public class MediaTagsServiceImpl implements MediaTagsService {
    @Autowired
    private MediaTagsMapper mediaTagsMapper;

    @Override
    public List<String> findTagIdsByParentId(String parentId) {
        QueryWrapper<MediaTags> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        List<MediaTags> mediaTags = mediaTagsMapper.selectList(queryWrapper);
        List<String> tagIds = mediaTags.stream().sorted(Comparator.comparing(MediaTags::getTagId)).map(mediaTag -> mediaTag.getTagId()).collect(Collectors.toList());
        return tagIds;
    }

    @Override
    public void insert(List<String> tagIdList, String parentId) {
        for (String tagId : tagIdList) {
            String id = UuidUtil.getUuid();
            MediaTags mediaTags = new MediaTags(id, tagId, parentId);
            int insert = mediaTagsMapper.insert(mediaTags);
            if (insert < 1) {
                throw new SmException(60002,"标签插入失败");
            }
        }
    }




}
