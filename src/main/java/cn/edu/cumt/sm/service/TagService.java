package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.Tag;
import cn.edu.cumt.sm.vo.ResultVO;
import cn.edu.cumt.sm.vo.TagVO;
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
public interface TagService {

    /**
     * 批量查询标签
     * @param tagIds 标签id集合
     * @return List<TagVO>
     */
    List<TagVO> findTagVoByTagIds(List<String> tagIds);

    /**
     * 查询数据库所有标签
     * @return List<TagVO>
     */
    ResultVO get();

    List<TagVO> list();
}
