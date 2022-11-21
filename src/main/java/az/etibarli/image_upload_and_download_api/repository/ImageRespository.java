package az.etibarli.image_upload_and_download_api.repository;

import az.etibarli.image_upload_and_download_api.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRespository extends JpaRepository<Image, Long> {
}
