package io.yourvn.batch.bus.hn;

import io.yourvn.batch.util.BusUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
@Slf4j
public class FetchFullBusTask implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Fetch full bus....");
        HttpResponse<String> response = BusUtil.searchFullHNBus();
        if (response.statusCode() == HttpStatus.OK.value()) {
            String json = response.body();
            ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
            executionContext.put("fullBusInfo", json);
        }
//        return response.statusCode() == HttpStatus.OK.value() ? RepeatStatus.FINISHED : RepeatStatus.CONTINUABLE;
        return RepeatStatus.FINISHED;
    }
}
