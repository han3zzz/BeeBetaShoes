package com.spring.beebeta.authention;

import com.spring.beebeta.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomerService service;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        String token = null;
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        // Xác thực thông tin đăng nhập ở đây (ví dụ: kiểm tra tên người dùng và mật khẩu)
        // Nếu xác thực thành công, phát sinh mã JWT và trả về cho người dùng

        if (service.getByUsername(loginRequest.getUsername()) == null){
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");

        }
        if (!service.getByUsername(loginRequest.getUsername()).getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");
        }
        token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(new TokenResponse(token));
    }
    @GetMapping("/get")
    public ResponseEntity<?> getByToken(@RequestParam("token") String token) {

        return ResponseEntity.ok(jwtTokenUtil.getUsernameFromToken(token));
    }
}
