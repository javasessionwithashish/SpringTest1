package com.virinchi.controllerAdvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value= MaxUploadSizeExceededException.class)
public String maxSizeHandler( MaxUploadSizeExceededException e,  Model m)
{

m.addAttribute("errorSize","File Size Exceeded");
    return "gallery";
}

}
