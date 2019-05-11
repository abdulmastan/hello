package com.liquidhub.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lh.digital.integration.config.SpringToolsConfig;

//***** Uncomment the following two lines to add custom Pointcut Expressions
//import org.springframework.aop.aspectj.AspectJExpressionPointcut;
//import org.springframework.context.annotation.Bean;

@Configuration
@Import({SpringToolsConfig.class})
public class ApplicationConfig {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);;

    public ApplicationConfig() {
        logger.info("|||||||||||||||||||| Sample APPLICATIONCONFIG Message||||||||||||||||||||||||||");
    }

//***** Uncomment the following @Bean definition to add custom Pointcut Expressions.
//      Please enhance or add to this expression to retain the current tracing capabilities  ******//
//    @Bean
//    public AspectJExpressionPointcut tracingPointcut(){
//         String pointCutStr = "execution(* (@org.springframework.web.bind.annotation.RestController *).*(..))" + " || " +
//            "execution(* (@org.springframework.stereotype.Repository *).*(..))" + " || " +
//            "execution(* (@org.springframework.stereotype.Service *).*(..))";
//         AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//            pointcut.setExpression(pointCutStr);
//         return pointcut;
//    }

//***** Uncomment the following @Bean definition to change the trace intercept message.
//      Please enhance or add to this expression to retain the current tracing capabilities  ******//
//    @Bean
//    public String interceptorString () {
//        String defaultString = "$[targetClassShortName] using METHOD: '$[methodName]'";
//
//        return defaultString;
//    }
}