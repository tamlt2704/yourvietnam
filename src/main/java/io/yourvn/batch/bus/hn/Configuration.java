package io.yourvn.batch.bus.hn;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private FetchFullBusTask fetchFullBusTask;

    @Autowired
    private FetchBusDetailTask fetchBusDetailTask;

    @Bean
    public Job fetchHNBusDataJob() {
        return jobBuilderFactory.get("fetchHNBusDataJob")
                .incrementer(new RunIdIncrementer())
                .start(fetchBusInfo())
                .next(fetchBusDetail())
                .build();
    }

    private Step fetchBusDetail() {
        return stepBuilderFactory.get("fetchFullBusStep")
                .tasklet(fetchFullBusTask)
                .build();
    }

    private Step fetchBusInfo() {
        return stepBuilderFactory.get("fetchBusInfo")
                .tasklet(fetchBusDetailTask)
                .build();
    }
}
