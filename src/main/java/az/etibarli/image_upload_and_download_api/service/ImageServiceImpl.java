package az.etibarli.image_upload_and_download_api.service;

import az.etibarli.image_upload_and_download_api.entity.Image;
import az.etibarli.image_upload_and_download_api.repository.ImageRespository;
import az.etibarli.image_upload_and_download_api.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRespository imageRespository;

    @Override
    public boolean upload(MultipartFile file) throws Exception {
        if (file.getSize() != 0) {
            createImage(file);
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadMany(MultipartFile[] files) throws Exception {
        if (files.length != 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].getSize() != 0) {
                    createImage(files[i]);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public byte[] download(Long id) throws Exception {
        Image image = imageRespository.findById(id).get();
        return FileUtil.downloadFileFromFolder(image.getPath());
    }

    private Image createImage(MultipartFile file) throws Exception {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setPath("F:\\Workspace\\Photo\\" + file.getOriginalFilename());
        imageRespository.save(image);
        FileUtil.uploadFileToFolder(file);
        return image;
    }
}
