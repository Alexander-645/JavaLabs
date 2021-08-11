package org.rptp.java.CallerClassAndMethod;

public class CallerClassAndMethod {

    public static String getCallerClassAndMethodName() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String message = "";
        if (stackTraceElements.length > 3) {
            StackTraceElement element = stackTraceElements[2];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            message = className + "#" + methodName;
            return message;
        }
        return null;
    }
}
