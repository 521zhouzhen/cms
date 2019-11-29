package com.briup.apps.cms.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.utils.Message;

@RestController

@RequestMapping("/file")
public class FileController {

	@PostMapping("/upload")
	public Message upload() {

		return null;

	}

}
