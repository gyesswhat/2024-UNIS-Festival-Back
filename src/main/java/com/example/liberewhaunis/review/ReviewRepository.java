package com.example.liberewhaunis.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(name="Review.findLatestReviews", nativeQuery = true)
    List<ReviewListDto> findLatestReviews();
}
