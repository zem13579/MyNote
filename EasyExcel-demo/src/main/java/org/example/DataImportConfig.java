package org.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "data-import-config")
@Data
public class DataImportConfig {

    private List<ReportInfo> reportInfos;

    @Data
    static class ReportInfo{
        private String reportName;
        private List<ColInfo> colInfos;

        @Data
        public static class ColInfo{
            private String fieldCnName;
            private String fieldEnName;
            private String fieldType;
        }
    }

    @PostConstruct
    public void postConstruct(){

    }
}
