package com.virinchi.RestControllerTest;

import com.virinchi.model.UserClass;
import com.virinchi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTest {
@Autowired
    private UserRepository uRepo;

    @GetMapping("/api/getAll")
    public List<UserClass> getAll() {

return uRepo.findAll();

    }
}
