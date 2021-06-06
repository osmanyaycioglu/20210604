package com.training.spring.di;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "conversation")
public class LanguageProperties {

    private String               language;
    private int                  zone;
    private List<String>         allLanguage;
    private Map<String, Dialect> dialects;
    private Dialect              currentDialect;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String languageParam) {
        this.language = languageParam;
    }


    public int getZone() {
        return this.zone;
    }


    public void setZone(final int zoneParam) {
        this.zone = zoneParam;
    }


    public List<String> getAllLanguage() {
        return this.allLanguage;
    }


    public void setAllLanguage(final List<String> allLanguageParam) {
        this.allLanguage = allLanguageParam;
    }


    public Map<String, Dialect> getDialects() {
        return this.dialects;
    }


    public void setDialects(final Map<String, Dialect> dialectsParam) {
        this.dialects = dialectsParam;
    }


    public Dialect getCurrentDialect() {
        return this.currentDialect;
    }


    public void setCurrentDialect(final Dialect currentDialectParam) {
        this.currentDialect = currentDialectParam;
    }


}
