package cn.edu.cumt.sm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Seeumt
 * @version v1
 */
@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class AliyunOssConfig {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String urlPrefix;

}
