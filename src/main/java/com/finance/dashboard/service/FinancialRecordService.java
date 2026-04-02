package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service 
public class FinancialRecordService {

    private final FinancialRecordRepository recordRepository;
    

    public FinancialRecordService(FinancialRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public FinancialRecord createRecord(FinancialRecord record) {
        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public FinancialRecord getRecordById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord record) {
        FinancialRecord existing = getRecordById(id);

        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        existing.setType(record.getType());
        existing.setDate(record.getDate());
        existing.setNotes(record.getNotes());

        return recordRepository.save(existing);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    public List<FinancialRecord> getByType(RecordType type) {
        return recordRepository.findByType(type);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return recordRepository.findByCategory(category);
    }

    public List<FinancialRecord> getByDateRange(LocalDate start, LocalDate end) {
        return recordRepository.findByDateBetween(start, end);
    }
}