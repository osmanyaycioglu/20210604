package com.training.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
// @Import()
// @PropertySource
public class ConversationConfig {

    @Autowired
    private Environment env;

    @Value("${conversation.language}")
    private String      language;

    @Bean
    @Qualifier("dynamic")
    public IConversation conCreation() {
        switch (this.language) {
            case "tr":
                return new TrConver();
            case "eng":
            case "en":
                return new EngConver();
            case "esp":
                return new EspConver();
            default:
                return new EngConver();
        }
    }

    //    @Bean
    //    @Qualifier("dynamic")
    //    public IConversation conCreation() {
    //        String propertyLoc = this.env.getProperty("conversation.language");
    //        switch (propertyLoc) {
    //            case "tr":
    //                return new TrConver();
    //            case "eng":
    //            case "en":
    //                return new EngConver();
    //            case "esp":
    //                return new EspConver();
    //            default:
    //                return new EngConver();
    //        }
    //    }

}
