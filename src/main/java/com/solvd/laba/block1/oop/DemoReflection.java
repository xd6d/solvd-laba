package com.solvd.laba.block1.oop;

import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.users.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

public class DemoReflection {
    private static final Logger LOGGER = LogManager.getLogger(DemoReflection.class);

    public static void main(String[] args) {
        String userAccountClassName = "com.solvd.laba.block1.oop.model.users.UserAccount";
        try {
            Class<UserAccount> userAccountClass = (Class<UserAccount>) Class.forName(userAccountClassName);
            LOGGER.info("Modifiers: " + Modifier.toString(userAccountClass.getModifiers()));
            LOGGER.info("Superclass: " + userAccountClass.getAnnotatedSuperclass());

            Field blocked = userAccountClass.getDeclaredField("blocked");
            LOGGER.info("Field in " + userAccountClass.getSimpleName() + ": " + blocked.getName());
            LOGGER.info("with type: " + blocked.getType().getSimpleName());
            LOGGER.info("and modifiers: " + Modifier.toString(blocked.getModifiers()));

            Constructor<UserAccount> constructor = userAccountClass.getConstructor
                    (String.class, String.class, String.class, String.class, String.class, Calendar.class);
            UserAccount userAccount = constructor.newInstance("John", "White", "john@example.com", "+11123456", "qwerty",
                    new GregorianCalendar(2000, Calendar.DECEMBER, 21));
            LOGGER.info("Created " + userAccountClass.getSimpleName() + ": " + userAccount);
            blocked.setAccessible(true);
            blocked.set(userAccount, true);
            Method isBlocked = userAccountClass.getMethod("isBlocked");
            LOGGER.info("Current value of " + blocked.getName() + " field: " + isBlocked.invoke(userAccount));

            Method toString = userAccountClass.getMethod("toString");
            LOGGER.info("Modifiers of toString(): " + Modifier.toString(toString.getModifiers()));
            LOGGER.info("Return type: " + toString.getReturnType().getName());
            LOGGER.info("Parameters: " + Arrays.stream(toString.getParameters())
                    .map(Parameter::getType)
                    .map(Type::getTypeName)
                    .collect(Collectors.joining()));

            Method setBlocked = userAccountClass.getMethod("setBlocked", boolean.class);
            LOGGER.info("Modifiers of setBlocked(boolean blocked): " + Modifier.toString(setBlocked.getModifiers()));
            LOGGER.info("Return type: " + setBlocked.getReturnType().getName());
            LOGGER.info("Parameters: " + Arrays.stream(setBlocked.getParameters())
                    .map(Parameter::getType)
                    .map(Type::getTypeName)
                    .collect(Collectors.joining()));
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }
}
