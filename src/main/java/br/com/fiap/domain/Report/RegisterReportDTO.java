package br.com.fiap.domain.Report;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record RegisterReportDTO(
        @Schema(name = "reportDate", example = "2023-11-20T18:29:36.835Z")
        LocalDateTime reportDate,
        ReportTrigger reportTrigger,
        @Schema(name = "reportValue", example = "1")
        String reportValue
) {
}
