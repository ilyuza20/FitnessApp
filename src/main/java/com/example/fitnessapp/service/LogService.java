package com.example.fitnessapp.service;

import com.example.fitnessapp.entity.Log;
import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.entity.Workout;
import com.example.fitnessapp.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Set;

@Service
public class LogService {

    private final LogRepository logRepository;
    private final UserService userService;

    @Autowired
    public LogService(LogRepository logRepository, UserService userService) {
        this.logRepository = logRepository;
        this.userService = userService;
    }

    public Log addLog(Long idUser, Log log) {
        User user = userService.getUserById(idUser);
        log.setDate(new Date());
        log.setUser(user);
        return logRepository.save(log);
    }

    public Set<Log> getLogs(Long idUser){
        User user = userService.getUserById(idUser);
        return user.getLogs();
    }

    public Log getLog(Long idUser, Long id){
        return logRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Запись не найдена"));
    }

    public  Log deleteLog(Long idUser, Long id){
        Log log = getLog(idUser, id);
        logRepository.delete(log);
        return  log;
    }

    public Log editLog(Long idUser, Long id, Log log){
        Log editLog = getLog(idUser, id);
        editLog.setDate(new Date());
        editLog.setCompleted(log.isCompleted());
        editLog.setWorkout(log.getWorkout());
        logRepository.save(editLog);
        return editLog;
    }
}
