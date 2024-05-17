package com.kh.app.util.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

import com.kh.app.board.vo.AttachmentVo;

public class FileUpload {

	
	//다른폴더에 저장하고싶으면 파일경로 나타내는 매개변수 하나 더 추가해야함(수업시간엔안함)
	public static AttachmentVo saveFile(Part f) throws Exception {//파일을 서버에 저장하는 메서드
		InputStream is = f.getInputStream();
        String path = "D:\\dev\\servletWorkspace\\prj99semi\\src\\main\\webapp\\resources\\upload\\";
        int random = (int)(Math.random() * 90000) + 10000;
        String originName = f.getSubmittedFileName();
        String ext = originName.substring(originName.lastIndexOf("."));
        String changeName = "KH_" + System.nanoTime() + "_" + random+ ext;
        FileOutputStream fos = new FileOutputStream(path + changeName);
        
        byte[] buf = new byte[1024];
        int size = 0;
        while( (size=is.read(buf)) != -1 ) {
           fos.write(buf , 0, size);
        }
        
        is.close();
        fos.close();
        
        AttachmentVo attVo = new AttachmentVo();
        attVo.setChangeName(changeName);
        attVo.setOriginName(originName);
        
        
        return attVo;
        
	}
	
}
