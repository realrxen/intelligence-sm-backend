package cn.edu.cumt.sm.controller;


import cn.edu.cumt.sm.service.NewsService;
import cn.edu.cumt.sm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping("/{tabId}")
    public ResultVO list(@PathVariable String tabId,
                         @RequestParam(value = "currentNum") int currentNum,
                         @RequestParam(value = "size",required = false,defaultValue = "10") int size) {
        return newsService.listNews(tabId,currentNum,size);
    }

    @GetMapping("/")
    public ResultVO list2() {
        return newsService.listNews2();
    }

}
