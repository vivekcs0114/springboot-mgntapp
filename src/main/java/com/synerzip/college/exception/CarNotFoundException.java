package com.synerzip.college.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CarNotFoundException extends RuntimeException {
}
