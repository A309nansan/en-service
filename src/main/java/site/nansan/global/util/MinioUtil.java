package site.nansan.global.util;

import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.nansan.en.entity.ImageType;

@Service
@RequiredArgsConstructor
public class MinioUtil {

    private final MinioClient minioClient;

    private final static String BASE_URL = "https://minio.nansan.site";

    public String getPreSignedUrl(String bucketName, String fileName) throws Exception {

        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .method(Method.GET)
                        .expiry(10 * 60) // 10분 유효
                        .build()
        );
    }

    public static String getStaticImageUrl(ImageType imageType, Integer number) {

        return BASE_URL + "/nansan/number" + "/" + imageType.name() + "/" + number.toString() + ".png";
    }

    /**
     * @param imageName 이미지 이름
     * @param path      경로 상의 존재하는 모든 directory 이름을 순서대로 입력
     * @return : 해당 이미지의 static url을 반환
     */
    public static String getStaticImageUrl(String imageName, String... path) {

        return BASE_URL + "/nansan" + "/" + String.join("/", path) + "/" + imageName + ".png";
    }
}
