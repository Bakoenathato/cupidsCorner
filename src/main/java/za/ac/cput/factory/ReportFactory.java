package za.ac.cput.factory;

import za.ac.cput.domain.Report;
import za.ac.cput.util.Helper;

public class ReportFactory {
    public static Report buildReport(long reportId, String reason, UserProfile userProfileReporter, UserProfile userProfileReported){
        if(Helper.isZeroOrLess(reportId) || Helper.isNullOrEmpty(reason) || userProfileReporter == null || userProfileReported == null)
            return null;
        return new Report.Builder().setReportId(reportId)
                .setReason(reason)
                .setUserProfileReporter(userProfileReporter)
                .setUserProfileReported(userProfileReported)
                .build();
    }

    public static Report buildReport(String reason, UserProfile userProfileReporter, UserProfile userProfileReported){
        if (Helper.isNullOrEmpty(reason) || userProfileReporter == null || userProfileReported == null)
            return null;

        long reportId = Helper.generateLongId();
        return new Report.Builder().setReportId(reportId)
                .setReason(reason)
                .setUserProfileReporter(userProfileReporter)
                .setUserProfileReported(userProfileReported)
                .build();
    }
}
