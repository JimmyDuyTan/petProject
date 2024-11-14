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

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "fullname")
public class FullName {
    //@Id: Đánh dấu trường là khóa chính.
    //@GeneratedValue: Chỉ định cách tự động sinh giá trị cho khóa chính.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "status")
    private String status;

    //@ManyToOne: Chỉ ra mối quan hệ nhiều-một, một FullName thuộc về một User.
    //@JoinColumn(name = "user_id"): Chỉ định cột user_id trong bảng FullName là khóa ngoại, tham chiếu đến cột id trong bảng User.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
