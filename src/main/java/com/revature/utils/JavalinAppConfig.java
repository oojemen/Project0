package com.revature.utils;

/**
 * @author Osey Ojemen
 * Date: 6/4/2023
 *  PROJECT0
 *
 *  Customer Management System
 *
 *  Purpose: This Application will accept HTTP requests and store them in a connected database.
 *  It utilizes a javalin framework to handle HTTP "CRUD" requests and responses.
 *
 *
 *
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig {

    Gson gson = new GsonBuilder().create();
    JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))

            //Add logger for debugging
            .before(ctx -> {

                logger.info(ctx.method() + " Request was sent to path: " + ctx.fullUrl());
            })

            .routes(() -> {
                path("customer", () -> {

                    // Method referencing
                    get(CustomerController::handleGetAll);
                    post(CustomerController::handleCreate);
                    path("{id}", () ->{
                        get(CustomerController::handleGetOne);
                    put(CustomerController::handleUpdate);
                    delete(CustomerController::handleDelete);
                    });
                });
                path("employee", () -> {
                    // Method referencing
                    get(EmployeeController::handleGetAll);
                    post(EmployeeController::handleCreate);
                    path("{id}", () ->{
                        get(EmployeeController::handleGetOne);
                    put(EmployeeController::handleUpdate);
                    delete(EmployeeController::handleDelete);
                    });
                });
            });

    //  start method to start our Javalin app
    public void start(int port){
        app.start(port);
    }
}