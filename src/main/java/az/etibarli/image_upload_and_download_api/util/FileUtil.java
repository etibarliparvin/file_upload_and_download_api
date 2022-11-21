package az.etibarli.image_upload_and_download_api.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class FileUtil {
    public static void uploadFileToFolder(MultipartFile file) throws Exception {
        Files.write(Path.of("F:\\Workspace\\Photo\\" + file.getOriginalFilename()), file.getBytes());
    }

    public static byte[] downloadFileFromFolder(String path) throws Exception {
        return Files.readAllBytes(Path.of(path));
    }

    public static byte[] encodeByteArray(byte[] bytes) throws Exception {
        return Base64.getEncoder().encode(bytes);
    }
}
