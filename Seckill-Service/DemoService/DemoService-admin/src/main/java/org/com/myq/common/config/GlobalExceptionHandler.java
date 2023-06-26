package org.com.myq.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;
import java.util.HashMap;
import java.util.Map;

@Priority(1)
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不可预知异常捕获 :捕获exception异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exception(Exception ex) {
        log.error("[GlobalExceptionHandler][exceptionHandler] exception {}", ex.getMessage(), ex);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", new Integer(500));
        result.put("msg", "内部错误");
        result.put("data", null);
        return result;
    }

}
