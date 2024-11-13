package com.icm.trabaruedas_api.controller;

import com.icm.trabaruedas_api.models.ButtonBoxModel;
import com.icm.trabaruedas_api.models.WheelLockModel;
import com.icm.trabaruedas_api.services.ButtonBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/button-box")
@RequiredArgsConstructor
public class ButtonBoxController {
    private final ButtonBoxService buttonBoxService;

    @GetMapping("/{id}")
    public ResponseEntity<ButtonBoxModel> findById(@PathVariable Long id){
        ButtonBoxModel data = buttonBoxService.findById(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public List<ButtonBoxModel> findAll(){
        return  buttonBoxService.findAll();
    }

    @GetMapping("/paged")
    public Page<ButtonBoxModel> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return buttonBoxService.findAll(pageable);
    }

    @GetMapping("/findByCompany/{companyId}")
    public List<ButtonBoxModel> findByCompany(@PathVariable Long companyId){
        return  buttonBoxService.findByCompany(companyId);
    }

    @GetMapping("/findByCompany-paged/{companyId}")
    public Page<ButtonBoxModel> findByCompany(@PathVariable Long companyId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return buttonBoxService.findByCompany(companyId, pageable);
    }

    @PostMapping
    public ResponseEntity<ButtonBoxModel> save(@RequestBody ButtonBoxModel buttonBoxModel){
        ButtonBoxModel data = buttonBoxService.save(buttonBoxModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ButtonBoxModel> editCompany(@PathVariable Long id, @RequestParam Long companyId){
        ButtonBoxModel data = buttonBoxService.editCompany(id, companyId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        buttonBoxService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
