package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.News;
import cn.edu.cumt.sm.vo.ResultVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-04-30
 */
public interface NewsService extends IService<News> {

    ResultVO listNews(String tabId,int currentNum, int size);

    ResultVO listNews2();

}
