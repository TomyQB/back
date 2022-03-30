package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.model.History;
import com.appuntate.back.repository.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    
    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAllByUserIdOrderByDate(long userId) {
        return historyRepository.findByUserUserIdOrderByDateAsc(userId);
    }

    public void save(History history) {
        historyRepository.save(history);
    }

    public void deleteAll() {
        historyRepository.deleteAll();
    }
}
