package com.udemy.parimparjob.step;

import com.udemy.parimparjob.chunk.ParImparChunkConfig;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ParImparChunkConfig parImparChunkConfig;

    @Bean
    public Step imprimeParImparStep() {
        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(1)
                .reader(parImparChunkConfig.contaAteDezReader())
                .processor(parImparChunkConfig.parOuImparProcessor())
                .writer(parImparChunkConfig.imprimeWriter())
                .build();
    }

}
