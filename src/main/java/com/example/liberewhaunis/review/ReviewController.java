package com.example.liberewhaunis.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    S3Service s3Service;

    @GetMapping("/reviews/latest")
    public ResponseEntity<?> getLatestReviews() {
        List<ReviewResponseDto> latestReviews = reviewService.getLatestReviews();
        return (latestReviews != null)?
                ResponseEntity.status(HttpStatus.OK).body(latestReviews):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아직 리뷰가 없습니다.");
    }

    @GetMapping("/reviews/best")
    public ResponseEntity<?> getBestReviews() {
        List<ReviewResponseDto> bestReviews = reviewService.getBestReviews();
        return (bestReviews != null)?
                ResponseEntity.status(HttpStatus.OK).body(bestReviews):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아직 리뷰가 없습니다.");
    }

    @PostMapping("/reviews/add")
    public ResponseEntity<?> addReview(@RequestPart(name="data") ReviewDto reviewDto, @RequestPart(name="file", required = false) List<MultipartFile> multipartFilelist) {
        List<ReviewImage> reviewImages;
        // 1. 리뷰 등록
        Review review = reviewService.addReview(reviewDto);
        if (review == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("리뷰 등록에 실패했습니다.");
        // 2. 리뷰 본문 사진 등록
        if (multipartFilelist != null) {
            reviewImages = s3Service.addReviewImages(review, multipartFilelist);
            if (reviewImages == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("사진 등록에 실패했습니다.");
            else return ResponseEntity.status(HttpStatus.OK).body(reviewImages);
        }
        // 3. 응답
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }
}
