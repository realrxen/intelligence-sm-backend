package cn.edu.cumt.sm.service.impl;

import cn.edu.cumt.sm.dataobject.Tab;
import cn.edu.cumt.sm.dao.TabMapper;
import cn.edu.cumt.sm.service.TabService;
import cn.edu.cumt.sm.vo.TabVO;
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
 * @since 2020-05-06
 */
@Service
public class TabServiceImpl implements TabService {

    @Autowired
    private TabMapper tabMapper;
    @Override
    public Tab selectByTabId(String tabId) {
        return tabMapper.selectById(tabId);
    }

    @Override
    public List<TabVO> list() {
        QueryWrapper<Tab> wrapper = new QueryWrapper<>();
        wrapper.eq("status", true);
        List<Tab> tabs = tabMapper.selectList(wrapper);
        return tabs.stream().map(tab -> {
            TabVO tabVO = new TabVO();
            BeanUtils.copyProperties(tab, tabVO);
            return tabVO;
        }).collect(Collectors.toList());

    }
}
