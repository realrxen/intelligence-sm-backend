package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.Attachment;
import cn.edu.cumt.sm.vo.AttachmentVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-09
 */
public interface AttachmentService {

    List<AttachmentVO> selectAttachmentVosByParentId(String parentId);

    void insertAttachment(Attachment attachment);
}
