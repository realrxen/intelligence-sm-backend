package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.Attachment;
import cn.edu.cumt.sm.dao.AttachmentMapper;
import cn.edu.cumt.sm.exception.SmException;
import cn.edu.cumt.sm.service.AttachmentService;
import cn.edu.cumt.sm.vo.AttachmentVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-09
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {


    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public List<AttachmentVO> selectAttachmentVosByParentId(String parentId) {
        QueryWrapper<Attachment> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId).eq("status", true);
        List<Attachment> attachments = attachmentMapper.selectList(wrapper);
        if (attachments.size() == 0) {
            return null;
        }
        return attachments.stream().map(attachment -> {
            AttachmentVO attachmentVO = new AttachmentVO();
            BeanUtils.copyProperties(attachment, attachmentVO);
            return attachmentVO;
        }).collect(Collectors.toList());
    }

    @Override
    public void insertAttachment(Attachment attachment) {
        int insert = attachmentMapper.insert(attachment);
        if (insert < 0) {
            throw new SmException(50001, "附件插入失败");
        }
    }
}
