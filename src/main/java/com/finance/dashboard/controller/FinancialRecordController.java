package com.finance.dashboard.controller;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.service.FinancialRecordService;
//
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    private final FinancialRecordService recordService;

    public FinancialRecordController(FinancialRecordService recordService) {
        this.recordService = recordService;
    }
//
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return recordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public FinancialRecord getById(@PathVariable Long id) {
        return recordService.getRecordById(id);
    }
//
//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return recordService.updateRecord(id, record);
    }
//
//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.deleteRecord(id);
    }

    // Filtering
//
//    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/type/{type}")

    public List<FinancialRecord> byType(@PathVariable RecordType type) {
        return recordService.getByType(type);
    }

    @GetMapping("/category/{category}")
    public List<FinancialRecord> byCategory(@PathVariable String category) {
        return recordService.getByCategory(category);
    }

    @GetMapping("/date")
    public List<FinancialRecord> byDate(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return recordService.getByDateRange(start, end);
    }
}