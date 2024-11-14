package src.springboot.blog.elearns.service.validator;

import src.springboot.blog.elearns.dto.request.UserLoginReq;

import java.util.regex.Pattern;

public class UserValidator {
    public String validatorLogin(UserLoginReq req){
        //Validate client's input
        String username = req.getUsername();
        String password = req.getPassword();
        String error = "";
        if(!isValidUsername(username)){
            error = "Tên đăng nhập không hợp lệ";
            return error;
        }
        if(!isValidPassword(password)){
            error = "Mật khẩu không hợp lệ";
            return error;
        }
        if(!isValidPassword(password) && !isValidUsername(username)){
            error = "Thông tin đăng nhập không hợp lệ";
            return error;
        }
        return error;
    }
    public boolean isValidUsername(String username){
        /*
        Regex: ^[a-zA-Z][a-zA-Z0-9_]{5,19}$
    ^: Bắt đầu của chuỗi.
    [a-zA-Z]: Ký tự đầu tiên phải là chữ cái in hoa hoặc thường.
    [a-zA-Z0-9_]{5,19}: Các ký tự tiếp theo có thể là chữ cái, số hoặc dấu gạch dưới, số lượng từ 5 đến 19 ký tự.
    $: Kết thúc của chuỗi.
         */
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
        return Pattern.compile(regex).matcher(username).matches();
    }
    public boolean isValidPassword(String password){
        /*
        Requirement:
        Phải chứa ít nhất một chữ cái in hoa.
        Phải chứa ít nhất một chữ số.
        Phải chứa ít nhất một ký tự đặc biệt.
        Regex: ^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$
        (?=.*[A-Z]): Phải chứa ít nhất một chữ cái in hoa.
        (?=.*\d): Phải chứa ít nhất một số.
        (?=.[@$!%*?&]):** Phải chứa ít nhất một ký tự đặc biệt. * **[A-Za-z\d@$!%?&]{8,}: Độ dài tối thiểu 8 ký tự, bao gồm các ký tự chữ cái, số và các ký tự đặc biệt đã định.
         */
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }
}
