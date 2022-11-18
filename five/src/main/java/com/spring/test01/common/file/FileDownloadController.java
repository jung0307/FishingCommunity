package com.spring.test01.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("fileDownloadController")
public class FileDownloadController {

	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\img";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName ,
			@RequestParam("boardNum") int boardNum	,HttpServletResponse resp) throws Exception{
		
		OutputStream os = resp.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" +boardNum+"\\" +imageFileName;
		File file = new File(downFile);
		
		System.out.println(downFile);
		
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = fis.read(buffer);
			if(count == -1) {
				break;
			}
			os.write(buffer, 0, count);
		}
		fis.close();
		os.close();
	}
	
	@RequestMapping("/downloadFree")
	protected void downloadFree(@RequestParam("imageFileName") String imageFileName ,
		@RequestParam("boardNum") int boardNum	,HttpServletResponse resp) throws Exception{
		
		CURR_IMAGE_REPO_PATH = CURR_IMAGE_REPO_PATH + "2";
		
		OutputStream os = resp.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" +boardNum+"\\" +imageFileName;
		File file = new File(downFile);
		
		System.out.println(downFile);
		
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = fis.read(buffer);
			if(count == -1) {
				break;
			}
			os.write(buffer, 0, count);
		}
		fis.close();
		os.close();
 	}
}
