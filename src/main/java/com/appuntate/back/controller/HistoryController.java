package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.HistoryUserNotFoundException;
import com.appuntate.back.model.History;
import com.appuntate.back.model.dto.history.HistoryUserResponseDTO;
import com.appuntate.back.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/getUserHistory/{userId}")
    public List<HistoryUserResponseDTO> getUserHistory(@PathVariable long userId) throws HistoryUserNotFoundException {
        return historyService.getAllByUserId(userId);
    }
    
}
