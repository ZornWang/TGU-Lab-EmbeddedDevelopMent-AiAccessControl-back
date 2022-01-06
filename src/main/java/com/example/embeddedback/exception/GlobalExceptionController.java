package com.example.embeddedback.exception;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.state.ResponseState;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionController {
    @Autowired
    private Logger logger;
    /**
     * 处理请求参数格式错误的返回信息，json格式时
     *
     * @param e：MethodArgumentNotValidException异常
     * @return 102
     */
    @ExceptionHandler
    public Result<Object> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        System.out.println(e);
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = null;
        for (ObjectError error : errors) {
            if (message != null) {
                message = message + ";" + error.getDefaultMessage();
            } else {
                message = error.getDefaultMessage();
            }
        }
        logger.error(message);
        return Result.error(message, ResponseState.PARAM_IS_ERROR.getStatusCode());
    }
    /**
     * 处理请求参数格式错误的返回信息,form-data格式时
     *
     * @param e：BindException异常
     * @return 102
     */
    @ExceptionHandler
    public Result<Object> BindExceptionHandler(BindException e) {
        System.out.println(e);
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return Result.error(message, ResponseState.PARAM_IS_ERROR.getStatusCode());
    }


    /**
     * 处理请求参数格式错误的返回信息，param格式时
     *
     * @param e：MethodArgumentNotValidException异常
     * @return 102
     */
    @ExceptionHandler
    public Result<Object> constraintViolationException(ConstraintViolationException e) {
        String message = e.getMessage();
        System.out.println(message);
        return Result.error(message, ResponseState.PARAM_IS_ERROR.getStatusCode());
    }

    /**
     * 请求参数错误
     *
     * @param e：请求参数错误
     * @return 102
     */
    @ExceptionHandler
    public Result<Object> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error(ResponseState.PARAM_IS_ERROR.getMessage());
        logger.error(e.getLocalizedMessage());
        return Result.error(ResponseState.PARAM_IS_ERROR.getMessage(), ResponseState.PARAM_IS_ERROR.getStatusCode());
    }
    /**
     * 唯一值在数据库中重复
     * Duplicate entry ' ' for key ' '
     * @param e：重复键异常
     * @return 199
     */
    @ExceptionHandler
    public Result<Object> DuplicateKeyException(DuplicateKeyException e) {
        logger.error(ResponseState.DUPLICATE_KEY.getMessage());
        logger.error(e.getLocalizedMessage());
        System.err.println(e.getCause().getMessage());
        final String message = e.getCause().getMessage();
        final String[] split = message.split("'");//分割出错误信息，错误信息对应数据库中索引的name
        System.out.println("11111111111111"+ Arrays.toString(split));
        return Result.error(ResponseState.DUPLICATE_KEY.getMessage(), ResponseState.DUPLICATE_KEY.getStatusCode(),split[3]);
    }

    /**
     *  删除时缺少id
     *
     * @param e：缺少Servlet请求参数异常
     * @return 199
     */
    @ExceptionHandler
    public Result<Object> MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error(ResponseState.MISSING_SERVLET_REQUEST_PARAMETER.getMessage());
        logger.error(e.getLocalizedMessage());
        System.err.println(e.getMessage());
        return Result.error(ResponseState.MISSING_SERVLET_REQUEST_PARAMETER.getMessage(), ResponseState.MISSING_SERVLET_REQUEST_PARAMETER.getStatusCode(),e.getMessage());
    }

    /**
     *  删除时缺少id
     *
     * @param e：缺少Servlet请求参数异常
     * @return 199
     */
    @ExceptionHandler
    public Result<Object> TransactionalException(TransactionalException e) {
        System.out.println(e.toString());//TransactionalException(code=197)
        System.out.println(e.getCode());//197
        System.out.println(e.getLocalizedMessage());//操作失败（事务）
        System.err.println(e.getMessage());//操作失败（事务）
        logger.error(ResponseState.TRANSACTIONAL_IS_WORKED.getMessage());//2021-08-22 13:06:49.839 ERROR 43560 --- [nio-8082-exec-2] rConfig$$EnhancerBySpringCGLIB$$9591bd41 : 操作失败（事务）
        logger.error(e.getLocalizedMessage());//2021-08-22 13:06:49.839 ERROR 43560 --- [nio-8082-exec-2] rConfig$$EnhancerBySpringCGLIB$$9591bd41 : 操作失败（事务）
        return Result.error(e.getMessage(),e.getCode());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<Object> Exception(Exception e) {
        System.out.println(e.getMessage());
        return Result.error(e.getMessage());
    }
}
