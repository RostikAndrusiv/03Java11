package jmp.cloud.service.impl.exception;

import jmp.dto.ErrorType;

public class SubscriptionNotFoundException extends ServiceException{

        private static final String DEFAULT_MESSAGE = "Sub is not found!";

        public SubscriptionNotFoundException() {
            super(DEFAULT_MESSAGE);
        }

        @Override
        public ErrorType getErrorType() {
            return ErrorType.DATABASE_ERROR_TYPE;
        }
}
