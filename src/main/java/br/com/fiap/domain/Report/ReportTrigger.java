package br.com.fiap.domain.Report;

public enum ReportTrigger {
    TEMPERATURY("temperature"),
    HEARTBEAT("heartbeat");

    private String reportTrigger;

    ReportTrigger(String reportTrigger) {
        this.reportTrigger = reportTrigger;
    }

    public String getReportTrigger() {
        return this.reportTrigger;
    }
}
