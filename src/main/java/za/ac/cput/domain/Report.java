package za.ac.cput.domain;

/* Report.java
Report model class
Author: Leonard Gabriel Langa (221069054)
Date: 17 May 2024
*/

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Report 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;
    private String reason;

    @CreatedDate
    private LocalDateTime reportedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileID")
    @Column(name = "reportingUserId")
    private UserProfile userProfileReporter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileID")
    @Column(name = "reportedUserId")
    private UserProfile userProfileReported;

    protected Report(){}

    private Report(Builder builder) {
        this.reportId = builder.reportId;
        this.reason = builder.reason;
        this.reportedAt = builder.reportedAt;
        this.userProfileReporter = builder.userProfileReporter;
        this.userProfileReported = builder.userProfileReported;
    }

    public long getReportId() {
        return reportId;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public UserProfile getUserProfileReporter() {
        return userProfileReporter;
    }

    public UserProfile getUserProfileReported() {
        return userProfileReported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report report)) return false;
        return reportId == report.reportId && Objects.equals(reason, report.reason) && Objects.equals(reportedAt, report.reportedAt) && Objects.equals(userProfileReporter, report.userProfileReporter) && Objects.equals(userProfileReported, report.userProfileReported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reason, reportedAt, userProfileReporter, userProfileReported);
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reason='" + reason + '\'' +
                ", reportedAt=" + reportedAt +
                ", userProfileReporter=" + userProfileReporter +
                ", userProfileReported=" + userProfileReported +
                '}';
    }

    public static class Builder{
        private long reportId;
        private String reason;
        private LocalDateTime reportedAt;
        private UserProfile userProfileReporter;
        private UserProfile userProfileReported;

        public Builder setReportId(long reportId) {
            this.reportId = reportId;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setReportedAt(LocalDateTime reportedAt) {
            this.reportedAt = reportedAt;
            return this;
        }

        public Builder setUserProfileReporter(UserProfile userProfileReporter) {
            this.userProfileReporter = userProfileReporter;
            return this;
        }

        public Builder setUserProfileReported(UserProfile userProfileReported) {
            this.userProfileReported = userProfileReported;
            return this;
        }

        public Builder copy(Report report){
            this.reportId = report.reportId;
            this.reason = report.reason;
            this.reportedAt = report.reportedAt;
            this.userProfileReporter = report.userProfileReporter;
            this.userProfileReported = report.userProfileReported;
            return this;
        }

        public Report build(){
            return new Report(this);
        }
    }
}
