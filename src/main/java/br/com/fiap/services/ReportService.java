package br.com.fiap.services;

import br.com.fiap.domain.Report.RegisterReportDTO;
import br.com.fiap.domain.Report.Report;
import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserService userService;


    public Page<Report> findAll(String id, Pageable page) {
        return reportRepository.findByUserId(UUID.fromString(id), page);
    }

    public Report createRelatory(RegisterReportDTO data, String id) {
        Report newReport = new Report(data);
        User user = userService.findUserById(id);
        newReport.setUser(user);
        return reportRepository.save(newReport);
    }
}
