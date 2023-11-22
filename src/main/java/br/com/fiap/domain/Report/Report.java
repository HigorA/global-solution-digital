package br.com.fiap.domain.Report;

import br.com.fiap.domain.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reportDate;
    @Enumerated(EnumType.STRING)
    private ReportTrigger reportTrigger;
    private String reportValue;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Report() {}

    public Report(RegisterReportDTO data) {
        this.reportDate = data.reportDate();
        this.reportTrigger = data.reportTrigger();
        this.reportValue = data.reportValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public ReportTrigger getReportTrigger() {
        return reportTrigger;
    }

    public void setReportTrigger(ReportTrigger reportTrigger) {
        this.reportTrigger = reportTrigger;
    }

    public String getReportValue() {
        return reportValue;
    }

    public void setReportValue(String reportValue) {
        this.reportValue = reportValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
