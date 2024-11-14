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

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "user_address")
/*
User_Address: Bảng trung gian, tạo mối liên kết nhiều-nhiều giữa User và Address.
Điều này có nghĩa là một người dùng có thể có nhiều địa chỉ và một địa chỉ có thể
thuộc về nhiều người dùng (ví dụ: địa chỉ công ty, địa chỉ nhà).
 */
public class UserAddress {
    @EmbeddedId
    private UserAddressId id;

    //@MapsId: Liên kết khóa chính hợp thành với các khóa chính của các bảng liên quan.
    @ManyToOne
    @MapsId("userId")
    private User user;

    //@MapsId: Liên kết khóa chính hợp thành với các khóa chính của các bảng liên quan.
    @ManyToOne
    @MapsId("addressId")
    private Address address;

    //@Embeddable: Đánh dấu lớp UserAddressId là một embedded id.
    @Embeddable
    public static class UserAddressId implements Serializable {
        private int userId;
        private int addressId;
    }
}
