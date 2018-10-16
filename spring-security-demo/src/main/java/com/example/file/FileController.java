
package com.example.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

	@PostMapping
	public String upload(MultipartFile file) throws Exception {

		String folder = "/Users/songhaibei/springSecurity/spring-security-parent";
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());

		File localFile = new File(folder, new Date() + ".txt");
		file.transferTo(localFile);

		String path = localFile.getAbsolutePath();
		return path;
	}

}
