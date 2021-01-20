package com.mcallydevelops.springresilience4jsample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    //    @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
//    @RateLimiter(name = "backendA")
//    @Bulkhead(name = "backendA")
//    @Retry(name = "backendA", fallbackMethod = "fallback")
    @GetMapping("/timelimiter")
    public String getTimeLimiterExample() throws Exception {
        return sampleService.timeLimiterTest().get();
    }
}
