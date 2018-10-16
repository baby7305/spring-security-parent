
package com.example.file;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String folder = "/Users/songhaibei/springSecurity/spring-security-parent";
		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();) {

			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");

			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		}
	}

}
