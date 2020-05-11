package cn.edu.cumt.sm.controller;

import cn.edu.cumt.sm.model.FileCloud;
import cn.edu.cumt.sm.utils.AliyunOssUtil;
import cn.edu.cumt.sm.vo.ResultVO;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/9 21:52
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class UpLoadController {
    @PostMapping("/")
    public ResultVO fileUpload(@RequestPart("file") MultipartFile[] files) throws IOException, HttpException {
        List<FileCloud> fileCloudList = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String url = AliyunOssUtil.getHttpsUrl(AliyunOssUtil.cutSuffix(AliyunOssUtil.getOriginUrl(file)));
            FileCloud fileCloud = new FileCloud(fileName, url);
            fileCloudList.add(fileCloud);
        }
        return ResultVO.success(fileCloudList);
    }
}
