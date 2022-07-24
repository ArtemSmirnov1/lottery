package com.lottery.services;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "random-numbers", url = "${random-numbers.url}")
public interface RandomNumberService {
    @RequestMapping(
        method = RequestMethod.GET,
        value = "${random-numbers.urn}",
        consumes = "text/plain"
    )
    String getRandomNumber(
        @RequestParam("min") Long min, @RequestParam("max") Long max);
}
