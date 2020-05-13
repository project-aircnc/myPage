package analysis;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Dashboard_table")
public class Dashboard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String status;
        private String requestInfo;
        private String analysisInfo;
        private String requester;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getRequestInfo() {
            return requestInfo;
        }

        public void setRequestInfo(String requestInfo) {
            this.requestInfo = requestInfo;
        }
        public String getAnalysisInfo() {
            return analysisInfo;
        }

        public void setAnalysisInfo(String analysisInfo) {
            this.analysisInfo = analysisInfo;
        }
        public String getRequester() {
            return requester;
        }

        public void setRequester(String requester) {
            this.requester = requester;
        }

}
