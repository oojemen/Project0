package com.revature.utils;

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


    // Adding some space in here, so we can format our GSON object mapper for Javalin to use.
    // I'm copying this directly from the javalin docs at https://javalin.io/documentation#configuring-the-json-mapper
    // Make sure to import everything

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

    // Let's add in instances of our controllers so we can use the methods
    private final CustomerController customerController = new CustomerController();
    private final EmployeeController employeeController = new EmployeeController();


    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);


    // We'll create a private usage for our Javalin app, so we can only configure it here
    // Now that we have GSON, let's update the coonfig (again pulled directly from Javalin Docs)
    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))

            //Add logger for debugging
            .before(ctx -> {
                // This logic here will run before ALL requests to the server
                // We want to use to log our request sent
                logger.info(ctx.method() + " Request was sent to path: " + ctx.fullUrl());
            })
            // This is where we're going to register our routes for our API
            // Shouldn't be too bad, just mind the lambdas and try to get an understanding of how this comes together
            // Notice these all come from Javalin's APIBuilder
            .routes(() -> {
                path("customer", () -> {

                    // Method referencing
                    get(CustomerController::handleGetAll);
                    post(CustomerController::handleCreate);
                    put(CustomerController::handleUpdate);
                    delete(CustomerController::handleDelete);
                    path("{id}", () ->{
                        get(CustomerController::handleGetOne);
                    });
                });
                path("employee", () -> {
                    // Method referencing
                    get(EmployeeController::handleGetAll);
                    post(EmployeeController::handleCreate);
                    put(EmployeeController::handleUpdate);
                    delete(EmployeeController::handleDelete);
                    path("{id}", () ->{
                        get(EmployeeController::handleGetOne);
                    });
                });
            });

    // We'll have a single public method called start to start our Javalin app, this will be called in the driver class
    public void start(int port){
        app.start(port);
    }
}