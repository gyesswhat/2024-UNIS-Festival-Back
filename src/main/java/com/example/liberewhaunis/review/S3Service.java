package com.example.liberewhaunis.review;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    @Autowired
    ReviewImageRepository reviewImageRepository;

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public List<ReviewImage> addReviewImages(Review review, List<MultipartFile> multipartFilelist) {
        List<ReviewImage> files = new ArrayList<>();
        try {
            String dirName = UUID.randomUUID().toString();

            int i = 0;
            for (MultipartFile multipartFile : multipartFilelist) {
                // 1. UUID를 사용하여 임의의 파일명 생성
                String originalFilename = multipartFile.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String fileName = dirName + "-" + i + extension;

                // 2. S3에 파일 업로드
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(multipartFile.getContentType());
                metadata.setContentLength(multipartFile.getSize()); // 파일의 크기를 명시적으로 지정
                InputStream inputStream = multipartFile.getInputStream();
                PutObjectRequest request = new PutObjectRequest(bucket, fileName, inputStream, metadata);
                PutObjectResult result = amazonS3.putObject(request);

                String fileUrl = amazonS3.getUrl(bucket, fileName).toString();

                // 3. 엔티티 저장
                ReviewImage reviewImage = new ReviewImage(null, fileUrl, review);
                ReviewImage saved = reviewImageRepository.save(reviewImage);
                files.add(saved);

                i++;
            }

            return files;

        } catch (IOException e) {
            e.printStackTrace(); // Handle exception properly
            return null;
        }

    }
}
