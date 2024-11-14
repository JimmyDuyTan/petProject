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
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})

/*
mối quan hệ giữa hai bảng FullName và User.
Mối quan hệ này được thể hiện qua trường user_id trong bảng FullName
đóng vai trò là khóa ngoại, tham chiếu đến trường id (khóa chính) của bảng User.
Điều này cho thấy một người dùng (User) có thể có nhiều thông tin tên đầy đủ (FullName)
khác nhau.
 */
public class User {
    //@Id: Đánh dấu trường là khóa chính.
    //@GeneratedValue: Chỉ định cách tự động sinh giá trị cho khóa chính.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "nick_name")
    private String nickname;

    //@OneToMany: Chỉ ra mối quan hệ một-nhiều, một User có thể có nhiều FullName.
    @OneToMany(mappedBy = "user")
    private List<FullName> fullNames = new ArrayList<>();

    //CascadeType.ALL: Khi xóa một User, tất cả các UserCourse liên quan cũng sẽ bị xóa.
    //@OneToMany: Chỉ ra mối quan hệ một-nhiều, một User có thể có nhiều Course.
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private Set<UserCourse> userCourses = new HashSet<>();

    //CascadeType.ALL: Khi xóa một User, tất cả các UserAddress liên quan cũng sẽ bị xóa.
    //@OneToMany: Chỉ ra mối quan hệ một-nhiều, một User có thể có nhiều Address.
    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    private Set<UserAddress> addresses = new HashSet<>();
}
