package cn.edu.cumt.sm.bo;

import cn.edu.cumt.sm.dataobject.Card;
import cn.edu.cumt.sm.vo.TagVO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/3 22:59
 */
@Data
public class NewsBO {

    /**
     * 新闻id
     */
    private String newsId;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 封面图片
     */
    @JsonProperty("cover")
    private String coverPicture;

    /**
     * 摘要
     */
    private String summary;


    /**
     * html内容
     */
    private String htmlContent;

    /**
     * 标签组
     */
    private List<TagVO> tags;



    /**
     * 审核人员
     */
    private String checker;

    /**
     * 编辑人员
     */
    private String editor;

    /**
     * 摄影人员
     */
    private String photographer;

    /**
     * 浏览次数
     */
    private String watchTimes;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm" ,timezone = "GMT+8 ")
    private Date createTime;


    private String tabId;

}
