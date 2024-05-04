package com.example.liberewhaunis.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    S3Service s3Service;
    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewListDto> getLatestReviews() {
        return null;
    }

    public List<ReviewListDto> getBestReviews() {
        return null;
    }

    public Review addReview(ReviewDto reviewDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt = LocalDateTime.now().format(formatter);
        Review review = new Review(
                null,
                createdAt,
                reviewDto.getTitle(),
                reviewDto.getBody(),
                reviewDto.getRating(),
                reviewDto.getNickname(),
                reviewDto.getPassword()
        );
        return reviewRepository.save(review);
    }
}
