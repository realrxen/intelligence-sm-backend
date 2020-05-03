package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.Tag;
import cn.edu.cumt.sm.dao.TagMapper;
import cn.edu.cumt.sm.service.TagService;
import cn.edu.cumt.sm.vo.ResultVO;
import cn.edu.cumt.sm.vo.TagVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-05-03
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVO> findTagVoByTagIds(List<String> tagIds) {
        List<Tag> tags = tagMapper.selectBatchIds(tagIds);
        List<TagVO> tagVos = new ArrayList<>();
        for (Tag tag : tags) {
            TagVO tagVO = new TagVO();
            BeanUtils.copyProperties(tag,tagVO);
            tagVO.setIsSelected(false);
            tagVos.add(tagVO);
        }
        return tagVos;
    }

    @Override
    public ResultVO get() {
        List<TagVO> tagVos = tagMapper.selectList(null).stream().map(tag -> {
            TagVO tagVO = new TagVO();
            BeanUtils.copyProperties(tag, tagVO);
            return tagVO;
        }).collect(Collectors.toList());
        return ResultVO.success(tagVos);
    }
}
