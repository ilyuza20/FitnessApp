package com.example.fitnessapp.controller;

import com.example.fitnessapp.entity.Log;
import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/users/{idUser}/logs")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public @ResponseBody
    Log addLog(@PathVariable Long idUser, @Valid @RequestBody Log log){
        return logService.addLog(idUser, log);
    }

    @GetMapping("/{id}")
    public Log getLog(@PathVariable Long idUser, @PathVariable Long id){
        return logService.getLog(idUser, id);
    }

    @GetMapping
    public @ResponseBody
    Set<Log> getLogs(@PathVariable Long idUser){
        return logService.getLogs(idUser);
    }

    @PutMapping("/{id}")
    public Log editLog(@PathVariable Long idUser, @PathVariable final Long id, @RequestBody Log log){
        return logService.editLog(idUser, id, log);
    }

    @DeleteMapping("/{id}")
    public Log deleteLog(@PathVariable Long idUser, @PathVariable final Long id){
        return logService.deleteLog(idUser, id);
    }
}
