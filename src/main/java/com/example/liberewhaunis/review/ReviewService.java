package com.example.liberewhaunis.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    S3Service s3Service;
    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewResponseDto> getLatestReviews() {
        List<ReviewListDto> sortedReviews = reviewRepository.findLatestReviews();
        List<ReviewResponseDto> latestReviews = new ArrayList<>();
        for (ReviewListDto sortedReview : sortedReviews) {
            latestReviews.add(new ReviewResponseDto(
                    sortedReview.getReviewId(),
                    sortedReview.getTitle(),
                    sortedReview.getBody(),
                    sortedReview.getImageLinksArray(),
                    sortedReview.getRating(),
                    sortedReview.getNickname()
            ));
        }
        return latestReviews;
    }

    public List<ReviewResponseDto> getBestReviews() {
        return null;
    }

    public List<BriefReviewResponseDto> getLatestReviewsBrief() {
        List<ReviewListDto> sortedReviews = reviewRepository.findLatestReviews();
        List<BriefReviewResponseDto> latestReviewsBrief = new ArrayList<>();
        for (int i=0; i<5; i++)
            latestReviewsBrief.add(new BriefReviewResponseDto(
                    sortedReviews.get(i).getReviewId(),
                    sortedReviews.get(i).getTitle(),
                    sortedReviews.get(i).getBody(),
                    sortedReviews.get(i).getRating()
            ));
        return latestReviewsBrief;
    }

    public List<BriefReviewResponseDto> getBestReviewsBrief() {
        return null;
    }

    public Review addReview(ReviewDto reviewDto) {
        if (reviewDto.getTitle().equals("") || reviewDto.getBody().equals("") || reviewDto.getPassword().equals("") || reviewDto.getNickname().equals("")) return null;
        if (reviewDto.getRating()>5.0 || reviewDto.getRating()<0.0) return null;
        String pattern = "\\d+";
        if (reviewDto.getPassword().length()!=4 || !reviewDto.getPassword().matches(pattern)) return null;
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
