package com.springboot.transaction.advice;

import com.springboot.transaction.constant.ErrorConstant;
import com.springboot.transaction.dto.ErrorResponseDTO;
import com.springboot.transaction.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Leonardo Siagian
 * Created on 12/03/2024
 */
@ControllerAdvice
@RequestScope
@Slf4j
public class ExceptionAdvice {
    private String code;
    private final MessageSource messageSource;

    public ExceptionAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleSftpException(CustomException ex) {
        this.code = ex.getMessage();
        String errorMessage = getMessageFromResourceBundle();
        if (Objects.nonNull(ex.getAdditionalValue())) {
            errorMessage = String.format(errorMessage, ex.getAdditionalValue());
        }
        return new ErrorResponseDTO(this.code, errorMessage);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleException(Exception ex) {
        this.code = ex.getMessage();
        String errorMessage = getMessageFromResourceBundle();
        log.error("SftpExceptionAdvice::handleException, error {}, detail ", errorMessage, ex);
        return new ErrorResponseDTO(this.code, errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleMethodNotValidException(MethodArgumentNotValidException ex) {
        AtomicReference<String> code= new AtomicReference<>();
        if (!ex.getAllErrors().isEmpty()) {
            ex.getAllErrors().stream().findFirst().ifPresent(msg -> code.set(msg.getDefaultMessage()));
        }

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(code.get());
        if (matcher.find()) {
            this.code = matcher.group();
        }

        String errorMessage = getMessageFromResourceBundle();
        AtomicReference<String> newMessage = new AtomicReference<>();
        FieldError fieldError = ex.getBindingResult().getFieldError();
        if (Objects.isNull(fieldError)){
            ex.getBindingResult().getFieldErrors()
                    .forEach(data->
                            newMessage.set(String.format(errorMessage, data.getField())));
        } else {
            newMessage.set(String.format(errorMessage, fieldError.getField()));
        }

        log.error("SftpExceptionAdvice::handleMethodNotValidException {}, detail: ", newMessage.get(), ex);
        return new ErrorResponseDTO(this.code,newMessage.get());
    }

    public String getMessageFromResourceBundle() {
        try {
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException ex) {
            log.error("SftpExceptionAdvice::getMessageFromResourceBundle, error : detail " + ex);
            this.code = ErrorConstant.DEFAULT_ERROR_CODE;
            return ErrorConstant.DEFAULT_ERROR_MESSAGE;
        }
    }
}
