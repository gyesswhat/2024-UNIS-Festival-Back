package com.example.liberewhaunis.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="review")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedNativeQueries(
        @NamedNativeQuery(
                name="Review.findLatestReviews",
                query="SELECT r.review_id, r.title, r.body, r.rating, r.nickname, " +
                        "GROUP_CONCAT(ri.image_link SEPARATOR ';') AS image_links " +
                        "FROM Review r " +
                        "LEFT JOIN review_image ri ON r.review_id = ri.review_id " +
                        "GROUP BY r.review_id " +
                        "ORDER BY r.created_at DESC",
                resultSetMapping = "LatestReviewMapping"
        )
)
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name="LatestReviewMapping",
                classes={
                        @ConstructorResult(
                                targetClass = ReviewListDto.class,
                                columns = {
                                        @ColumnResult(name="review_id", type= Integer.class),
                                        @ColumnResult(name="title", type=String.class),
                                        @ColumnResult(name="body", type=String.class),
                                        @ColumnResult(name="image_links", type=String.class),
                                        @ColumnResult(name="rating", type=Float.class),
                                        @ColumnResult(name="nickname", type= String.class)
                                }
                        )
                }
        )
)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @Column
    private String createdAt;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Float rating;
    @Column
    private String nickname;
    @Column
    private String password;
    @Column
    private String customerPhone;
}
