package cn.edu.cumt.sm.service;

import cn.edu.cumt.sm.dataobject.Tab;
import cn.edu.cumt.sm.vo.TabVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Seeumt
 * @since 2020-05-06
 */
public interface TabService {

    Tab selectByTabId(String tabId);

    List<TabVO> list();
}
