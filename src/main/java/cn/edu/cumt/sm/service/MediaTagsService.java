package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.MediaTags;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-03
 */
public interface MediaTagsService{

    /**
     * 找到某一id下的所有标签id
     * @param parentId 父级id
     * @return List<String>
     */
    List<String> findTagIdsByParentId(String parentId);

    /**
     * 插入标签为某id(article,post)
     * @param tagIdList 标签ids
     * @param parentId articleId,postId
     */
    void insert(List<String> tagIdList,String parentId);

}
