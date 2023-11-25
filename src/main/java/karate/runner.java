package karate;
import com.intuit.karate.Runner;
import com.intuit.karate.Results;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class runner { public static void main(String[] args) {
    // Provide the path to your Karate feature file or directory containing feature files.
    String karateOutputPath = "classpath:src/test/karateoutput";
    Results results = Runner.path("src/test/features/backendautomation.feature")
            .outputHtmlReport(true)
            .parallel(0);
    generateReport(results.getReportDir());
}

public static void generateReport(String karateOutputPath){
    System.out.println(karateOutputPath+":karatepath");
    Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
    List<String> jsonPaths = new ArrayList<>((jsonFiles.size()));
    jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
    Configuration config = new Configuration(new File("target"), "report-name");
    ReportBuilder reportBuilder= new ReportBuilder(jsonPaths, config);
    reportBuilder.generateReports();
}
}
