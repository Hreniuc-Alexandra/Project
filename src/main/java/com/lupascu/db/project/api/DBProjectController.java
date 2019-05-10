package com.lupascu.db.project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DBProjectController.API_NAME)
public class DBProjectController {
    public static final String API_NAME = "/api/v1";
}
