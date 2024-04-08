package com.example.oop_cw_v1;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceReportGeneration extends AbstractReportGenerator{

    @Override
    public void generateReport(List<AttendanceData> allAttendanceData) {
        try {
            // Load JRXML template
            String reportTemplatePath = "src/main/resources/com/example/oop_cw_v1/Attendance.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplatePath);

            // Fill the report with data
            Map<String, Object> parameters = new HashMap<>();
            // parameters
            parameters.put("ReportTitle", "Attendance Report");

            // Convert the entire attendance data list to a JRDataSource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(allAttendanceData);

            // Create JasperPrint (filled report)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Check if the report contains any pages
            if (jasperPrint.getPages().isEmpty()) {
                // Display a dialog box with the message
                JOptionPane.showMessageDialog(null, "The report contains no pages.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Show the report using JasperViewer
                JasperViewer.viewReport(jasperPrint, false);
                System.out.println("Report displayed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error displaying the report.");
        }
    }
}