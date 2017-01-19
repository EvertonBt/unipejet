package br.com.unipejet.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;


@Component
public class FileSaver {


	// Salvando localmente sem usar o ninja
	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file) {
		
		String realPath = request.getServletContext().getRealPath("/"+baseFolder);
		
		try {
		//String path = realPath+"/"+file.getOriginalFilename();
			String pathServidor ="F:\\imagens\\";

			String caminhoCompleto = pathServidor + file.getOriginalFilename();

			file.transferTo(new File(caminhoCompleto));
		//file.transferTo(new File(path));
		return baseFolder+"/"+file.getOriginalFilename();
		} catch (IOException e) {
		throw new RuntimeException(e);
		}
	
	}
	

 /*
	@Autowired
	private AmazonS3Client s3;

	public String write(String baseFolder, MultipartFile multipartFile) {
		try {
			s3.putObject("casadocodigo", multipartFile.getOriginalFilename(),
					multipartFile.getInputStream(), new ObjectMetadata());
			return "http://localhost:9444/s3/casadocodigo/"+multipartFile.getOriginalFilename()+"?noAuth=true";
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}

*/
	}










