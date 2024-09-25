package org.re.helloworldspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController: Biến class thành một controller để xử lý các request HTTP.
@GetMapping: Map một request GET đến một method cụ thể.
return: Trả về kết quả của method, trong trường hợp này là một chuỗi = "Hello course online project"
 */
@RestController
public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello course online project";
    }
}
