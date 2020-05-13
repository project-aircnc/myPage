package analysis;

import analysis.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequested_then_CREATE_1 (@Payload Requested requested) {
        try {
            if (requested.isMe()) {
                // view 객체 생성
                Dashboard dashboard = new Dashboard();
                // view 객체에 이벤트의 Value 를 set 함
                dashboard.setId(requested.getId);
                dashboard.setRequestInfo(requested.getRequestInfo);
                dashboard.setRequester(requested.getRequester);
                dashboard.setStatus(requested.getRequestStatus);
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenAnalysisCompleted_then_UPDATE_1(@Payload AnalysisCompleted analysisCompleted) {
        try {
            if (analysisCompleted.isMe()) {
                // view 객체 조회
                Optional<Dashboard> dashboardOptional = dashboardRepository.findById(analysisCompleted.getRequestId);
                if( dashboardOptional.isPresent()) {
                    Dashboard dashboard = dashboardOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setAnalysisInfo(analysisCompleted.getAnalysisInfo);
                    dashboard.setStatus(analysisCompleted.getAnalStatus);
                    // view 레파지 토리에 save
                    dashboardRepository.save(dashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenEquipStatusUpdated_then_UPDATE_2(@Payload EquipStatusUpdated equipStatusUpdated) {
        try {
            if (equipStatusUpdated.isMe()) {
                // view 객체 조회
                Optional<Dashboard> dashboardOptional = dashboardRepository.findById(equipStatusUpdated.getRequestId);
                if( dashboardOptional.isPresent()) {
                    Dashboard dashboard = dashboardOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setStatus(equipStatusUpdated.getEquipStatus);
                    // view 레파지 토리에 save
                    dashboardRepository.save(dashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenEquipStatusUpdated_then_DELETE_1(@Payload EquipStatusUpdated equipStatusUpdated) {
        try {
            if (equipStatusUpdated.isMe()) {
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}