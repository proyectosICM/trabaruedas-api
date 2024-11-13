package com.icm.trabaruedas_api.controller;

import com.icm.trabaruedas_api.models.CompanyModel;
import com.icm.trabaruedas_api.models.WheelLockModel;
import com.icm.trabaruedas_api.services.WheelLockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/wheel-lock")
@RequiredArgsConstructor
public class WheelLockController {
    private final WheelLockService wheelLockService;

    @GetMapping("/{id}")
    public ResponseEntity<WheelLockModel> findById(@PathVariable Long id){
        WheelLockModel data = wheelLockService.findById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public List<WheelLockModel> findAll(){
        return  wheelLockService.findAll();
    }

    @GetMapping("/paged")
    public Page<WheelLockModel> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return wheelLockService.findAll(pageable);
    }

    @GetMapping("/macs-company/{companyId}")
    public List<String> findMacsByCompany(@PathVariable Long companyId) {
        return wheelLockService.findMacsByCompany(companyId);
    }

    @GetMapping("/findByCompany/{companyId}")
    public List<WheelLockModel> findByCompany(@PathVariable Long companyId){
        return  wheelLockService.findByCompany(companyId);
    }

    @GetMapping("/findByCompany-paged/{companyId}")
    public Page<WheelLockModel> findByCompany(@PathVariable Long companyId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return wheelLockService.findByCompany(companyId, pageable);
    }

    @PostMapping
    public ResponseEntity<WheelLockModel> save(@RequestBody WheelLockModel wheelLockModel){
        WheelLockModel data = wheelLockService.save(wheelLockModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/edit-mac/{id}")
    public ResponseEntity<WheelLockModel> editMac(@PathVariable Long id, @RequestParam String newMac){
        WheelLockModel data = wheelLockService.editMac(id, newMac);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/edit-company/{id}")
    public ResponseEntity<WheelLockModel> editCompany(@PathVariable Long id, @RequestParam Long companyId){
        WheelLockModel data = wheelLockService.editCompany(id, companyId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        wheelLockService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
