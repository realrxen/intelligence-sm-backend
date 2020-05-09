package cn.edu.cumt.sm.controller;


import cn.edu.cumt.sm.service.TagService;
import cn.edu.cumt.sm.vo.ResultVO;
import cn.edu.cumt.sm.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-03
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;
    @GetMapping("/")
    public ResultVO list() {
        List<TagVO> tagVos  = tagService.list();
        return ResultVO.success(tagVos);
    }
}
