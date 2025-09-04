package com.virinchi.RestControllerTest;

import com.virinchi.model.Employee;
import com.virinchi.model.UserClass;
import com.virinchi.repository.EmployeeRepo;
import com.virinchi.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestTest {
@Autowired
    private UserRepository uRepo;

@Autowired
private EmployeeRepo eRepo;

    @GetMapping("/api/getAll")
    public List<UserClass> getAll() {

return uRepo.findAll();

    }

    @GetMapping("/api/getAllEmp")
    public List<Employee> getAllEmp() {

        return eRepo.findAll();

    }

    @GetMapping("/api/getId/{id}")
    public Optional<UserClass> getId(@PathVariable int id)
    {

      return uRepo.findById(id);
    }

    @PostMapping("/api/saveUser")
    public String saveUser(@RequestBody UserClass user)
    {
        String password=user.getPassword();

        String hashPassword= DigestUtils.md5Hex(password.getBytes());

        user.setPassword(hashPassword);

uRepo.save(user);
return "Successfully saved in Database";
    }



}
