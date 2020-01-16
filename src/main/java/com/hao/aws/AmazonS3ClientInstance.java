package com.hao.aws;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * <code>AmazonS3ClientInstance</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/4
 * @version: 1.0
 */
public class AmazonS3ClientInstance {

    private static final Logger logger = LoggerFactory.getLogger(AmazonS3ClientInstance.class);

    private static AmazonS3Client instance;

    private static final String accessKeyId = "AKIAOAYZXO3JUCFTYA6A";
    private static final String secretAccessKey = "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";
    private static final String bucketName = "smc-unilever";

    private AmazonS3ClientInstance() {
        ClientConfiguration clientConfig;
        BasicAWSCredentials basicCred;

        try {
            basicCred = new BasicAWSCredentials(accessKeyId, secretAccessKey);
            clientConfig = new ClientConfiguration();
            clientConfig.setProtocol(Protocol.HTTP);
        } catch (Throwable t) {
            throw new AmazonClientException("failed!", t);
        }
        instance = new AmazonS3Client(basicCred, clientConfig);
        Region region = Region.getRegion(Regions.CN_NORTH_1);
        final String serviceEndpoint = region.getServiceEndpoint(ServiceAbbreviations.S3);
        instance.setRegion(region);
        instance.setEndpoint(serviceEndpoint);
    }

    private static synchronized AmazonS3Client getInstance() {
        if(instance == null) {
            long startTime = System.currentTimeMillis();
            new AmazonS3ClientInstance();
            logger.info("Create amazon s3 instance time: [{}] ms", (System.currentTimeMillis() - startTime) );
        }
        return instance;
    }

    public static void deleteFile(String fileName) {
        getInstance().deleteObject(bucketName, fileName);
    }

    public static PutObjectResult putFile(String uploadFileName, File fbFile) {
        return getInstance().putObject(new PutObjectRequest(bucketName, uploadFileName, fbFile));
    }

    public static void main(String[] args) {
//        File file = new File("/Users/haoxueqiang/test/test1/hao1.zip");
//        PutObjectResult result = AmazonS3ClientInstance.putFile("hao111.zip",file);
//        System.out.println(new Gson().toJson(result));

    AmazonS3ClientInstance.deleteFile("3314bb35-03b2-40ff-891f-3f8166cb9fbb.pg");

    }
}
