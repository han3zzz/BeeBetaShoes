package com.spring.beebeta.authention.admin;

import com.spring.beebeta.authention.JwtTokenUtil;
import com.spring.beebeta.authention.LoginRequest;
import com.spring.beebeta.entity.Customer;
import com.spring.beebeta.entity.Employee;
import com.spring.beebeta.repository.EmployeeRepository;
import com.spring.beebeta.service.CustomerService;
import com.spring.beebeta.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth/admin")
public class AuthController1 {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        String token = null;
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        // Xác thực thông tin đăng nhập ở đây (ví dụ: kiểm tra tên người dùng và mật khẩu)
        // Nếu xác thực thành công, phát sinh mã JWT và trả về cho người dùng
        Employee employee = service.getByUsername(loginRequest.getUsername());
        if (employee == null){
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");

        }
        if (!employee.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("errorMessage");
        }

        token = jwtTokenUtil.generateToken(loginRequest.getUsername());
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        tokenMap.put("token",token);
        return new ResponseEntity<Map<String,Object>>(tokenMap,HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getByToken(@RequestParam("token") String token) {

        Map<String, Object> tokenMap = new HashMap<String, Object>();
        tokenMap.put("username",jwtTokenUtil.getUsernameFromToken(token));
        return new ResponseEntity<Map<String,Object>>(tokenMap,HttpStatus.OK);
    }
}
