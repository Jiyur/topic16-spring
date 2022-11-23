package abc.com.vn.commerce.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmazonService {
    private final AmazonS3 amazonS3;

    @Value("${amazonProperties.endpointUrl}")
    private String endPoint;
    @Value("${amazonProperties.bucketName}")
    private String bucketDefault;
    @Value("${amazonProperties.default-folder}")
    private String folderDefault;

    @Async
    public void createBucket(String bucketName) {
        amazonS3.createBucket(bucketName);
    }

//    @Async
    public String uploadFile(String objectName, byte[] content, String type) {
        try {
            if (!amazonS3.doesBucketExistV2(bucketDefault)) {
                this.createBucket(bucketDefault);
            }
            InputStream inputStream = new ByteArrayInputStream(content);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(type);
            metadata.setContentLength(content.length);
            String path = folderDefault + "logo-icon/" + objectName;
            amazonS3.putObject(bucketDefault, path, inputStream, metadata);
            log.info("upload file success");
            return endPoint + "/" + path;
        } catch (AmazonServiceException e) {
            log.error("Error {} occurred while uploading file", e.getLocalizedMessage());
            return null;
        }
    }

    @SneakyThrows
    public S3Object getFile(String folderClient, String objectName) {
        try {
            folderClient = folderClient + "/";
            String path = folderDefault + folderClient + objectName;
            return amazonS3.getObject(bucketDefault, path);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    public S3Object getFile(String objectUrl) {
        String path = folderDefault + objectUrl;
        try {
            return amazonS3.getObject(bucketDefault, path);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Async
    public void deleteFile(String folderClient, String objectName) {
        folderClient = folderClient + "/";
        String path = folderDefault + folderClient + objectName;
        amazonS3.deleteObject(bucketDefault, path);
    }
}
