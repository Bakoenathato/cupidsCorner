package za.ac.cput.factory;

/* ReportFactory.java
ReportFactory class
Author: Leonard Gabriel Langa (221069054)
Date: 17 May 2024
*/

import za.ac.cput.domain.Report;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class ReportFactory {
    public static Report buildReport(long reportId, String reason, LocalDateTime reportedAt,
                                     UserProfile userProfileReporter, UserProfile userProfileReported){
        if(Helper.isZeroOrLess(reportId) || Helper.isNullOrEmpty(reason) || reportedAt == null ||
                userProfileReporter == null || userProfileReported == null)
            return null;
        return new Report.Builder().setReportId(reportId)
                .setReason(reason)
                .setReportedAt(reportedAt)
                .setUserProfileReporter(userProfileReporter)
                .setUserProfileReported(userProfileReported)
                .build();
    }

    public static Report buildReport(String reason, LocalDateTime reportedAt, UserProfile userProfileReporter, UserProfile userProfileReported){
        if (Helper.isNullOrEmpty(reason) || reportedAt == null || userProfileReporter == null || userProfileReported == null)
            return null;
        LocalDateTime.now();
        long reportId = Helper.generateLongId();
        return new Report.Builder().setReportId(reportId)
                .setReason(reason)
                .setReportedAt(reportedAt)
                .setUserProfileReporter(userProfileReporter)
                .setUserProfileReported(userProfileReported)
                .build();
    }


}
