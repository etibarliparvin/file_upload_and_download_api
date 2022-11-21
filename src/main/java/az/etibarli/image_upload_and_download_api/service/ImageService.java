package az.etibarli.image_upload_and_download_api.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    boolean upload(MultipartFile file) throws Exception;

    boolean uploadMany(MultipartFile[] files) throws Exception;

    byte[] download(Long id) throws Exception;
}
