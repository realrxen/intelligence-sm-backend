package cn.edu.cumt.sm.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Seeumt
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通用返回类",description = "通用返回类")
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -6721853439167521929L;
    @ApiModelProperty(example="0")
    private Integer code;
    @ApiModelProperty(example="成功")
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;




    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(Integer code, String msg, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(Object object, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }



    public static ResultVO success(Integer code,String msg,Boolean isOk) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(isOk);
        return resultVO;
    }





    public static ResultVO error(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("操作失败");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Integer code,String msg,Boolean isOk) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(isOk);
        return resultVO;
    }



}
