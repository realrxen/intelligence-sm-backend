package cn.edu.cumt.sm.controller;


import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.service.CardService;
import cn.edu.cumt.sm.vo.ResultVO;
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
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/")
    public ResultVO list() {
        List<Card> cards = cardService.listCards();
        return ResultVO.success(cards);
    }

}
