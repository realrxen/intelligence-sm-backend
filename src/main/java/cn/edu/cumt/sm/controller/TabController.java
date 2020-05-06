package cn.edu.cumt.sm.controller;


import cn.edu.cumt.sm.service.TabService;
import cn.edu.cumt.sm.vo.ResultVO;
import cn.edu.cumt.sm.vo.TabVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-06
 */
@RestController
@RequestMapping("/tabs")
public class TabController {

    @Autowired
    private TabService tabService;
    @GetMapping("/")
    public ResultVO list() {
        List<TabVO> tabVOList = tabService.list();
        return ResultVO.success(tabVOList);
    }
}
