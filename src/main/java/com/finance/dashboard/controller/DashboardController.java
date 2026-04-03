package com.finance.dashboard.controller;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.service.DashboardService;
//
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
//
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping("/total-income")
    public Double totalIncome() {
        return dashboardService.getTotalIncome();
    }

    @GetMapping("/total-expense")
    public Double totalExpense() {
        return dashboardService.getTotalExpense();
    }

    @GetMapping("/net-balance")
    public Double netBalance() {
        return dashboardService.getNetBalance();
    }

    @GetMapping("/category-wise")
    public Map<String, Double> categoryWise() {
        return dashboardService.getCategoryWiseTotals();
    }

    @GetMapping("/recent")
    public List<FinancialRecord> recent() {
        return dashboardService.getRecentActivities();
    }
}