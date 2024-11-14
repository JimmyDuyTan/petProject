package src.springboot.blog.elearns.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "user_course")
/*
Khóa chính hợp thành: Sử dụng khóa chính hợp thành trong bảng UserCourse để đảm bảo tính duy nhất của mỗi bản ghi (một người dùng chỉ được đăng ký một khóa học một lần).
Mối quan hệ nhiều-nhiều: Sử dụng bảng trung gian UserCourse để biểu diễn mối quan hệ nhiều-nhiều giữa User và Course.
Thông tin bổ sung: Bảng UserCourse lưu trữ thêm các thông tin liên quan đến việc người dùng tham gia khóa học như rating, review.
 */
public class UserCourse {
    //@EmbeddedId: Sử dụng cho khóa chính hợp thành (composite primary key) trong bảng UserCourse.
    @EmbeddedId
    private UserCourseId id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review")
    private String review;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "status")
    private String status;

    //@MapsId: Liên kết khóa chính hợp thành với các khóa chính của các bảng liên quan.
    @ManyToOne
    @MapsId("userId")
    private User user;

    //@MapsId: Liên kết khóa chính hợp thành với các khóa chính của các bảng liên quan.
    @ManyToOne
    @MapsId("courseId")
    private Course course;

    //@Embeddable: Đánh dấu lớp UserCourseId là một embedded id.
    @Embeddable
    public static class UserCourseId implements Serializable {
        private int userId;
        private int courseId;
    }
}
