package pe.edu.upc.micomedor.servicesInterfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadImageProductService {
    void init() throws IOException;
    String store(MultipartFile file);

    Resource loadAsResource(String filename);
}
