package com.ggs.event.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggs.event.entity.File;
import com.ggs.event.entity.R;
import com.ggs.event.service.IFileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/17 15:31
 */
@Slf4j
@RequestMapping("/api/file")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final IFileService fileService;

    // 1111
    @GetMapping("/list")
    public R<List<File>> queryFileList() {
        List<File> fileList = fileService.list();
        return R.ok(fileList);
    }

    @GetMapping("/add")
    public R<Boolean> addFile() {
        File file = new File();
        file.setType(".jpg");
        file.setSize(3333L);
        file.setName("测试1111zjzz");
        file.setUserId(1L);
        fileService.save(file);
        return R.ok();
    }

}
