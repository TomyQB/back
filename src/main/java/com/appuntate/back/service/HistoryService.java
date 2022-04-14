package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.HistoryUserNotFoundException;
import com.appuntate.back.mapper.history.HistoryUserMapper;
import com.appuntate.back.model.History;
import com.appuntate.back.model.dto.history.HistoryUserResponseDTO;
import com.appuntate.back.repository.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    
    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryUserMapper historyUserMapper;

    public List<HistoryUserResponseDTO> getAllByUserId(long userId) throws HistoryUserNotFoundException {
        List<History> histories = historyRepository.findByUserUserId(userId);

        if(histories.isEmpty()) throw new HistoryUserNotFoundException(Long.toString(userId));
        return historyUserMapper.entitiesToDTOs(histories);
    }

    public void save(History history) {
        historyRepository.save(history);
    }

    public void deleteAll() {
        historyRepository.deleteAll();
    }
}
