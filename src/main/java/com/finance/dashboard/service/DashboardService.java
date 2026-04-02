package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final FinancialRecordRepository recordRepository;

    public DashboardService(FinancialRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Double getTotalIncome() {
        return recordRepository.findAll().stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public Double getTotalExpense() {
        return recordRepository.findAll().stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public Double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Map<String, Double> getCategoryWiseTotals() {
        return recordRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        FinancialRecord::getCategory,
                        Collectors.summingDouble(FinancialRecord::getAmount)
                ));
    }

    public List<FinancialRecord> getRecentActivities() {
        return recordRepository.findAll().stream()
                .sorted(Comparator.comparing(FinancialRecord::getDate).reversed())
                .limit(5)
                .toList();
    }
}