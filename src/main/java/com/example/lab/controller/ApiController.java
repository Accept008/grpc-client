package com.example.lab.controller;

import cn.soundbus.library.spring.web.api.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    /**
     * 音乐列表
     *
     * @return
     */
    @GetMapping("/pushing/ListMusics")
    public ResponseEntity<SuccessResponse> listMusics() {
        SuccessResponse resp = SuccessResponse.buildOkResponse("api【/pushing/ListMusics】response...", "");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    /**
     * 音乐详情
     *
     * @return
     */
    @GetMapping("/pushing/DescribeMusic")
    public ResponseEntity<SuccessResponse> describeMusic() {
        SuccessResponse resp = SuccessResponse.buildOkResponse("api【/pushing/DescribeMusic】response...", "");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    /**
     * 添加音乐
     *
     * @return
     */
    @PostMapping("/pushing/CreateMusic")
    public ResponseEntity<SuccessResponse> createMusic() {
        SuccessResponse resp = SuccessResponse.buildOkResponse("api【/pushing/CreateMusic】response...", "");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    /**
     * 编辑音乐
     *
     * @return
     */
    @PostMapping("/pushing/UpdateMusic")
    public ResponseEntity<SuccessResponse> updateMusic() {
        SuccessResponse resp = SuccessResponse.buildOkResponse("api【/pushing/UpdateMusic】response...", "");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    /**
     * 删除音乐
     *
     * @return
     */
    @PostMapping("/pushing/DeleteMusic")
    public ResponseEntity<SuccessResponse> DeleteMusic() {
        SuccessResponse resp = SuccessResponse.buildOkResponse("api【/pushing/DeleteMusic】response...", "");
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }


}
