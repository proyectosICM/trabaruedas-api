package com.icm.trabaruedas_api.controller;

import com.icm.trabaruedas_api.models.CompanyModel;
import com.icm.trabaruedas_api.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> findById(@PathVariable Long id){
        CompanyModel data = companyService.findById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public List<CompanyModel> findAll(){
        return  companyService.findAll();
    }

    @GetMapping("/paged")
    public Page<CompanyModel> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return companyService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<CompanyModel> save(@RequestBody CompanyModel companyModel){
        CompanyModel data = companyService.save(companyModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyModel> edit(@PathVariable Long id, @RequestBody CompanyModel companyModel){
        CompanyModel data = companyService.edit(id, companyModel);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/change-credentials/{id}")
    public ResponseEntity<CompanyModel> changeCredentials(@PathVariable Long id, @RequestBody String username, @RequestBody String password){
        CompanyModel data = companyService.changeCredentials(id, username, password);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
