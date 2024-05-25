package com.example.lab1b_emt.web;

import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.HostDto;
import com.example.lab1b_emt.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/hosts")
public class HostRestController {
    private final HostService hostService;

    public HostRestController(HostService hostService) {
        this.hostService = hostService;
    }


    @GetMapping
    private List<Host> findAll() {
        return this.hostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable Long id) {
        return this.hostService.findById(id)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Host> add(@RequestBody HostDto hostDto) {
        return this.hostService.add(hostDto)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Host> edit(@PathVariable Long id, @RequestBody HostDto hostDto) {
        return this.hostService.edit(id, hostDto)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.hostService.deleteById(id);
        if (this.hostService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}