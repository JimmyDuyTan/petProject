package src.springboot.blog.elearns.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "teacher", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})

/*
Từ sơ đồ ERD cung cấp, chúng ta thấy mối quan hệ giữa hai bảng Teacher và Course.
Trường teacher_id trong bảng Course đóng vai trò là khóa ngoại,
tham chiếu đến trường id (khóa chính) của bảng Teacher.
Điều này cho thấy một giáo viên có thể dạy nhiều khóa học.
 */
public class Teacher {
    //@Id: Đánh dấu trường là khóa chính.
    //@GeneratedValue: Chỉ định cách tự động sinh giá trị cho khóa chính.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    //@OneToMany: Chỉ ra mối quan hệ một-nhiều, một giáo viên có thể dạy nhiều khóa học.
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();
}
