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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "course")
public class Course {
    //@Id: Đánh dấu trường là khóa chính.
    //@GeneratedValue: Chỉ định cách tự động sinh giá trị cho khóa chính.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "status")
    private String status;

    //@ManyToOne: Chỉ ra mối quan hệ nhiều-một, nhiều khóa học duoc giang day boi một giáo viên.
    //@JoinColumn(name = "teacher_id"): Chỉ định cột teacher_id trong bảng Course là khóa ngoại,tham chiếu đến cột id trong bảng Teacher.
    //@ManyToOne: Chỉ ra mối quan hệ nhiều-một.
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    //@ManyToMany: Chỉ ra mối quan hệ nhiều-nhiều. 1 user co the hoc nhieu course. 1 course co the co nhieu user
    @ManyToMany(mappedBy = "courses")
    private Set<User> users = new HashSet<>();

    //OneToMany: Chỉ ra mối quan hệ một-nhiều. một khóa học co nhieu chapter
    //CascadeType: xoa 1 course thi tat ca cac chapter thuoc course do se deu bi xoa
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Chapter> chapters = new ArrayList<>();
}
